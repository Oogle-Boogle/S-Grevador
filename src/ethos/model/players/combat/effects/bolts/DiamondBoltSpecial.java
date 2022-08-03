package ethos.model.players.combat.effects.bolts;

import ethos.model.npcs.NPC;
import ethos.model.players.Player;
import ethos.model.players.combat.Damage;
import ethos.model.players.combat.DamageEffect;
import ethos.model.players.combat.range.RangeExtras;
import ethos.util.Misc;

public class DiamondBoltSpecial implements DamageEffect {

	@Override
	public void execute(Player attacker, Player defender, Damage damage) {
		int change = Misc.random((int) (damage.getAmount() * 1.15));
		damage.setAmount(change);
		RangeExtras.createCombatGraphic(attacker, defender, 758, false);
		defender.ignoreDefence = true;
	}

	@Override
	public void execute(Player attacker, NPC defender, Damage damage) {
		if (defender.getDefinition().getNpcName() == null) {
			return;
		}
		int change = Misc.random((int) (damage.getAmount() * 1.15));
		damage.setAmount(change);
		RangeExtras.createCombatGraphic(attacker, defender, 758, false);
	}

	@Override
	public boolean isExecutable(Player operator) {
		return RangeExtras.boltSpecialAvailable(operator, 9243);
	}

}
