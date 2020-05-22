package game;


import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
/**
 * Special Action for eating food.
 * @author ariehendrikse
 */
public class EatAction extends Action {
	
	private Food food;
	
	/**
	 * Constructor.
	 * 
	 * @param target the food to eat
	 */
	public EatAction(Item target) {
		food=(Food) target;
	}

	/**
	 * Removes the food from inventory, then heals the eater.
	 * 
	 * @return String : description of who ate the food
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		actor.removeItemFromInventory(food);
		actor.heal(food.getHealAmount());
		return actor.toString() + " ate some food and recovered " + food.getHealAmount() + " hit points";
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor.toString() + " eats food";
	}

}
