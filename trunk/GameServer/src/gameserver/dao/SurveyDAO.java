/**
 * This file is part of alpha team <alpha-team.com>.
 *
 * alpha team is pryvate software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * alpha team is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with alpha team.  If not, see <http://www.gnu.org/licenses/>.
 */
package gameserver.dao;

import com.aionemu.commons.database.dao.DAO;
import gameserver.model.gameobjects.Survey;

import java.util.List;

/**
 * @author ginho1
 */
public abstract class SurveyDAO implements DAO {

    @Override
    public final String getClassName() {
        return SurveyDAO.class.getName();
    }

    public abstract boolean deleteSurvey(int survey_id);

    public abstract List<Survey> loadSurveys(int playerId);

    public abstract Survey loadSurvey(int player_id, int survey_id);
}