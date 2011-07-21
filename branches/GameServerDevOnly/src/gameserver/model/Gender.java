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

package gameserver.model;

import javax.xml.bind.annotation.XmlEnum;

/**
 * Creature gender. Typically there are males and females. But who knows, maybe NC can invent something new ;)
 *
 * @author SoulKeeper
 */
@XmlEnum
public enum Gender {
    /**
     * Males
     */
    MALE(0),

    /**
     * Females
     */
    FEMALE(1),
    /**
     * Males & Females
     */
    ALL(2);

    /**
     * id of gender
     */
    private int genderId;

    /**
     * Constructor.
     *
     * @param genderId id of the gender
     */
    private Gender(int genderId) {
        this.genderId = genderId;
    }

    /**
     * Get id of this gender.
     *
     * @return gender id
     */
    public int getGenderId() {
        return genderId;
	}
}