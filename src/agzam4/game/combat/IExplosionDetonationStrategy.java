package agzam4.game.combat;

import mindustry.game.Team;

/**
 * The shared explosion-detonation logic that used to live directly on
 * {@code MindustryGameRuntimeFacade}'s four {@code explosion(...)} overloads, which all funneled
 * into the 8-arg one calling {@code Call.logicExplosion}.
 */
public interface IExplosionDetonationStrategy {

	/**
	 * Creating explosion at (x,y)
	 * @param team - owner of explosion (wasn't damaged)
	 * @param x - x position of explosion in world units
	 * @param y - x position of explosion in world units
	 * @param radius - radius of explosion in world units
	 * @param damage - amount of damage
	 * @param ground - is ground units was damaged
	 * @param air - is air units was damaged
	 * @param pierce - is damage piercing
	 */
	void explosion(Team team, float x, float y, float radius, float damage, boolean ground, boolean air, boolean pierce);
}
