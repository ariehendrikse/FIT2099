package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
/**
 * Action that presents a sub menu to choose an actor to shoot at with a sniper.
 * @author ariehendrikse
 *
 */
public class SnipeAction extends Action implements MenuAction {

	private SniperRifle gun;
	/**
	 * Constructor
	 * @param sniperRifle - the sniper to be shooting
	 */
	public SnipeAction(SniperRifle sniperRifle) {
		this.gun=sniperRifle;
	}

	@Override
	public Action getAction(Actor actor, GameMap map, Display display) {
		SubMenu sub = new SubMenu();
		Action action = null;
		// Goes through the list of available targets.
		for (Actor a : gun.getTargets(actor,map,gun)) {
			sub.addActionToMenu(new ShootAction(a,gun),actor,display,null);
		}
		action = sub.readInput(display);
		if (action instanceof MenuAction) {
			action = ((MenuAction) action).getAction(actor,map, display);
		}
		
		return action;	
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		return null;
	}
	@Override
	public String menuDescription(Actor actor) {
		return "Shoot";
	}

}
