/**
 * This file is part of Aion X Emu <aionxemu.com>
 *
 *  This is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This software is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser Public License
 *  along with this software.  If not, see <http://www.gnu.org/licenses/>.
 */
package gameserver.quest.handlers.template;

import gameserver.model.gameobjects.player.Player;
import gameserver.quest.handlers.QuestHandler;
import gameserver.quest.handlers.models.MonsterInfo;
import gameserver.quest.handlers.models.XmlQuestData;
import gameserver.quest.handlers.models.xmlQuest.events.OnKillEvent;
import gameserver.quest.handlers.models.xmlQuest.events.OnTalkEvent;
import gameserver.quest.model.QuestCookie;
import gameserver.quest.model.QuestState;

/**
 * @author Mr. Poke
 *
 */
public class XmlQuest extends QuestHandler
{

    private final XmlQuestData xmlQuestData;

    public XmlQuest(XmlQuestData xmlQuestData)
    {
        super(xmlQuestData.getId());
        this.xmlQuestData = xmlQuestData;
    }

    @Override
    public void register()
    {
        if (xmlQuestData.getStartNpcId() != null)
        {
            qe.setNpcQuestData(xmlQuestData.getStartNpcId()).addOnQuestStart(getQuestId());
            qe.setNpcQuestData(xmlQuestData.getStartNpcId()).addOnTalkEvent(getQuestId());
        }
        if (xmlQuestData.getEndNpcId() != null)
            qe.setNpcQuestData(xmlQuestData.getEndNpcId()).addOnTalkEvent(getQuestId());
        
        for (OnTalkEvent talkEvent : xmlQuestData.getOnTalkEvent())
            for (int npcId : talkEvent.getIds())
                qe.setNpcQuestData(npcId).addOnTalkEvent(getQuestId());

        for (OnKillEvent killEvent : xmlQuestData.getOnKillEvent())
            for (MonsterInfo monsterInfo : killEvent.getMonsterInfos())
                qe.setNpcQuestData(monsterInfo.getNpcId()).addOnKillEvent(getQuestId());
    }

    @Override
    public boolean onDialogEvent(QuestCookie env)
    {
        env.setQuestId(getQuestId());
        for (OnTalkEvent talkEvent : xmlQuestData.getOnTalkEvent())
        {
            if (talkEvent.operate(env))
                return true;
        }
        
        Player player = env.getPlayer();
        QuestState qs = player.getQuestStateList().getQuestState(getQuestId());
        
        if(defaultQuestNoneDialog(env, xmlQuestData.getStartNpcId()))
            return true;
        if(qs == null)
            return false;
        return defaultQuestRewardDialog(env, xmlQuestData.getEndNpcId(), 0);
    }

    @Override
    public boolean onKillEvent(QuestCookie env)
    {
        env.setQuestId(getQuestId());
        for (OnKillEvent killEvent : xmlQuestData.getOnKillEvent())
        {
            if(killEvent.operate(env))
                return true;
        }
        return false;
    }
}
