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
package gameserver.network.loginserver.serverpackets;

import gameserver.network.loginserver.LoginServerConnection;
import gameserver.network.loginserver.LsServerPacket;

import java.nio.ByteBuffer;

/**
 * This packet is sended by GameServer when player is requesting fast reconnect to login server. LoginServer in response
 * will send reconectKey.
 *
 * @author -Nemesiss-
 */
public class SM_ACCOUNT_RECONNECT_KEY extends LsServerPacket {
    /**
     * AccountId of client that is requested reconnection to LoginServer.
     */
    private final int accountId;

    /**
     * Constructs new instance of <tt>SM_ACCOUNT_RECONNECT_KEY </tt> packet.
     *
     * @param accountId account identifier.
     */
    public SM_ACCOUNT_RECONNECT_KEY(int accountId) {
        super(0x02);
        this.accountId = accountId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void writeImpl(LoginServerConnection con, ByteBuffer buf) {
        writeC(buf, getOpcode());
        writeD(buf, accountId);
	}
}
