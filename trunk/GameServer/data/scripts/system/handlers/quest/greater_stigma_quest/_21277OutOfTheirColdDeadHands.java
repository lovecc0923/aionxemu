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

package quest.greater_stigma_quest;

import gameserver.model.gameobjects.player.Player;
import gameserver.questEngine.handlers.QuestHandler;
import gameserver.questEngine.model.QuestCookie;
import gameserver.questEngine.model.QuestState;
import gameserver.questEngine.model.QuestStatus;


public class _21277OutOfTheirColdDeadHands extends QuestHandler
{
    private final static int questId = 21277;

    public _21277OutOfTheirColdDeadHands()
	{
        super(questId);
    }

    @Override
	public boolean onDialogEvent(QuestCookie env)
	{
		Player player = env.getPlayer();
		
		if(defaultQuestNoneDialog(env, 799208, 4762))
			return true;
			
		QuestState qs = player.getQuestStateList().getQuestState(questId);
		if(qs == null)
			return false;
			
		int var = qs.getQuestVarById(0);
		if(qs.getStatus() == QuestStatus.START)
		{
			if(env.getTargetId() == 799208)
			{
				switch(env.getDialogId())
				{
					case 26:
						if(var == 0)
							return sendQuestDialog(env, 1011);
						else if(var == 1)
							return sendQuestDialog(env, 1352);
					case 10000:
						return defaultCloseDialog(env, 0, 1);
					case 10001:
						return defaultCloseDialog(env, 1, 0);
					case 33:
						return defaultQuestItemCheck(env, 1, 0, true, 5, 10001);
				}
			}
		}
		return defaultQuestRewardDialog(env, 799208, 2375);
	}

    @Override
    public void register()
	{
        qe.setNpcQuestData(799208).addOnQuestStart(questId); //Garath
        qe.setNpcQuestData(799208).addOnTalkEvent(questId); //Garath
    }
}