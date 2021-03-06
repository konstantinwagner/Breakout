package de.tudarmstadt.informatik.fop.breakout.actions.game.items;

import de.tudarmstadt.informatik.fop.breakout.constants.GameParameters;
import de.tudarmstadt.informatik.fop.breakout.models.game.PlayerModel;
import de.tudarmstadt.informatik.fop.breakout.models.game.StickModel;

import eea.engine.entity.StateBasedEntityManager;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;


/**
 * Makes the stick smaller on item pickup
 */
public class SmallerItemAction extends AbstractItemAction {

    private StickModel stickModel;

    @Override
    protected void init(StateBasedGame stateBasedGame, PlayerModel catchingPlayer) {
        stickModel = (StickModel) StateBasedEntityManager.getInstance().getEntity(GameParameters.GAMEPLAY_STATE, catchingPlayer.isSecondPlayer() ? GameParameters.STICK_ID_PLAYER2 : GameParameters.STICK_ID);
    }

    @Override
    public void onEnable() {
        Vector2f oldSize = stickModel.getSize();
        int newWidth = (int) (oldSize.getX() * GameParameters.ITEM_SMALLER_CHANGE_VALUE);
        if(newWidth < GameParameters.STICK_MIN_WIDTH) newWidth = (int) GameParameters.STICK_MIN_WIDTH;

        stickModel.setSize(new Vector2f(newWidth, oldSize.getY()));
    }
}
