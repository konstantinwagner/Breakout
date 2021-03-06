package de.tudarmstadt.informatik.fop.breakout.actions.game.items;

import de.tudarmstadt.informatik.fop.breakout.constants.GameParameters;
import de.tudarmstadt.informatik.fop.breakout.models.game.BallModel;
import de.tudarmstadt.informatik.fop.breakout.models.game.PlayerModel;
import de.tudarmstadt.informatik.fop.breakout.states.GameplayState;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import java.util.List;

/**
 * Makes all balls in game faster on item pickup
 */
public class FasterItemAction extends AbstractItemAction {

    private List<BallModel> allBalls;

    @Override
    protected void init(StateBasedGame stateBasedGame, PlayerModel catchingPlayer) {
        // Get all balls from GameplayState
        allBalls = ((GameplayState) stateBasedGame.getState(GameParameters.GAMEPLAY_STATE)).getBalls();
    }

    @Override
    public void onEnable() {
        // Speed up all balls
        allBalls.forEach(ball -> {
            Vector2f oldVelocity = ball.getVelocity();
            ball.setVelocity(oldVelocity.scale(GameParameters.ITEM_FASTER_SPEEDUP_VALUE));
        });
    }
}
