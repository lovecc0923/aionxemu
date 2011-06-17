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
package gameserver.model.templates.mail;

/**
 * @author kosyachok
 */
public enum MailMessage {
    MAIL_SEND_SECCESS(0),
    NO_SUCH_CHARACTER_NAME(1),
    RECIPIENT_MAILBOX_FULL(2),
    MAIL_IS_ONE_RACE_ONLY(3),
    YOU_ARE_IN_RECIPIENT_IGNORE_LIST(4),
    RECIPIENT_IGNORING_MAIL_FROM_PLAYERS_LOWER_206_LVL(5), //WTF??
    MAILSPAM_WAIT_FOR_SOME_TIME(6);

    private int id;

    private MailMessage(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
