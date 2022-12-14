package ethos.model.players.packets.commands.all;

import java.util.Optional;

import ethos.Server;
import ethos.model.players.Player;
import ethos.model.players.packets.commands.Command;

public class Revs extends Command {

	@Override
	public void execute(Player c, String input) {
		if (Server.getMultiplayerSessionListener().inAnySession(c)) {
			return;
		}
		if (c.inClanWars() || c.inClanWarsSafe()) {
			c.sendMessage("@cr10@You can not teleport from here, speak to the doomsayer to leave.");
			return;
		}
		if (c.inWild()) {
			c.sendMessage("You can't use this command in the wilderness.");
			return;
		}
		c.getPA().spellTeleport(3126, 3833, 0, false);
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Teleports you to the rev cave @red@LvL 40 Wild!");
	}

}
