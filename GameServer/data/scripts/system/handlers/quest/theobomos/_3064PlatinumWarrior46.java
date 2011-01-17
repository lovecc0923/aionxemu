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

package quest.theobomos;

import gameserver.dataholders.DataManager;
import gameserver.dataholders.QuestsData;
import gameserver.model.PlayerClass;
import gameserver.model.gameobjects.Npc;
import gameserver.model.gameobjects.player.Player;
import gameserver.model.templates.QuestTemplate;
import gameserver.questEngine.handlers.QuestHandler;
import gameserver.questEngine.model.QuestCookie;
import gameserver.questEngine.model.QuestState;
import gameserver.questEngine.model.QuestStatus;
import gameserver.services.QuestService;

public class _3064PlatinumWarrior46 extends QuestHandler {

    static QuestsData questsData = DataManager.QUEST_DATA;
    private final static int questId = 3064;

    public _3064PlatinumWarrior46() {
        super(questId);
    }

    @Override
    public void register() {
        qe.setNpcQuestData(798172).addOnQuestStart(questId);
        qe.setNpcQuestData(798172).addOnTalkEvent(questId);
    }

    @Override
    public boolean onDialogEvent(QuestCookie env) {
        final Player player = env.getPlayer();
        if (player.getLevel() > 46)
            return false;
        int targetId = 0;
        if (env.getVisibleObject() instanceof Npc)
            targetId = ((Npc) env.getVisibleObject()).getNpcId();
        final QuestState qs = player.getQuestStateList().getQuestState(questId);
        QuestTemplate template = questsData.getQuestById(questId);

        if (targetId == 798172) {
            if (qs == null || qs.getStatus() == QuestStatus.NONE) {
                if (env.getDialogId() == 2) {
                    PlayerClass playerClass = player.getCommonData().getPlayerClass();
                    if (playerClass == PlayerClass.GLADIATOR || playerClass == PlayerClass.TEMPLAR || playerClass == PlayerClass.WARRIOR) {
                        QuestService.startQuest(env, QuestStatus.START);
                        return sendQuestDialog(env, 1011);
                    } else {
                        return sendQuestDialog(env, 3739);
                    }
                }
            } else if (qs != null && qs.getStatus() == QuestStatus.START) {
                if (env.getDialogId() == 2) {
                    return sendQuestDialog(env, 1011);
                } else if (env.getDialogId() == 10000) {
                    if (player.getInventory().getItemCountByItemId(186000005) >= 2000) {
                        qs.setQuestVarById(1, 0);
                        player.getInventory().removeFromBagByItemId(186000005, 2000);
                        qs.setStatus(QuestStatus.REWARD);
                        updateQuestStatus(env);
                        return sendQuestDialog(env, 5);
                    } else {
                        return sendQuestDialog(env, 1009);
                    }
                } else if (env.getDialogId() == 10001) {
                    if (player.getInventory().getItemCountByItemId(186000005) >= 400) {
                        qs.setQuestVarById(1, 1);
                        player.getInventory().removeFromBagByItemId(186000005, 400);
                        qs.setStatus(QuestStatus.REWARD);
                        updateQuestStatus(env);
                        return sendQuestDialog(env, 6);
                    } else {
                        return sendQuestDialog(env, 1009);
                    }
                } else if (env.getDialogId() == 10002) {
                    if (player.getInventory().getItemCountByItemId(186000005) >= 1000) {
                        qs.setQuestVarById(1, 2);
                        player.getInventory().removeFromBagByItemId(186000005, 1000);
                        qs.setStatus(QuestStatus.REWARD);
                        updateQuestStatus(env);
                        return sendQuestDialog(env, 7);
                    } else {
                        return sendQuestDialog(env, 1009);
                    }
                } else if (env.getDialogId() == 10003) {
                    if (player.getInventory().getItemCountByItemId(186000005) >= 200) {
                        qs.setQuestVarById(1, 3);
                        player.getInventory().removeFromBagByItemId(186000005, 200);
                        qs.setStatus(QuestStatus.REWARD);
                        updateQuestStatus(env);
                        return sendQuestDialog(env, 8);
                    } else {
                        return sendQuestDialog(env, 1009);
                    }
                }
            } else if (qs.getStatus() == QuestStatus.COMPLETE) {
                if (env.getDialogId() == 2) {
                    if ((qs.getCompliteCount() <= template.getMaxRepeatCount())) {
                        QuestService.startQuest(env, QuestStatus.START);
                        return sendQuestDialog(env, 1011);
                    } else
                        return sendQuestDialog(env, 1008);
                }
            } else if (qs != null && qs.getStatus() == QuestStatus.REWARD) {
                return defaultQuestEndDialog(env, qs.getQuestVarById(1));
            }
        }
        return false;
    }
}
