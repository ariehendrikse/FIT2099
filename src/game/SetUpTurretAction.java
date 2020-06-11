package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.GameMap;

public class SetUpTurretAction extends DropItemAction {
	
	private Turret turret;

	public SetUpTurretAction(Turret turret) {
		super(turret);
		this.turret = turret;
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		if (!map.locationOf(actor).getItems().contains(turret)) {  // If the turret isn't already on the ground, drop it
			super.execute(actor, map);
		}
		turret.setUp();
		return actor + " set up a turret";
	}
	
	@Override
	public String menuDescription(Actor actor) {
		return actor + " sets up the turret here";
	}

}
