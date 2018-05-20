package View;


import View.Misc.Renderable;
import View.Notification.INotification;
import View.Notification.INotificationReceiver;


class GameMapRenderable extends Renderable implements INotificationReceiver {

    private static final int fieldSide = 9;
    private final Renderable[][] field = new Renderable[fieldSide][fieldSide];

    GameMapRenderable() {
        colorR = 0.2f;
        colorG = 0.9f;
        colorB = 0.2f;

        for(int i = 0; i < fieldSide; i++) {
            for(int j = 0; j < fieldSide; j++) {
                Renderable tmp = new Renderable();
                tmp.setRectangle(1f*j, 1f*(j+1), 1f*(i+1), 1f*i);
                tmp.setColor(0f, (float) (i+j)/18, (float) Math.abs(i-j)/18);
                final int row = i, col = j;
                tmp.setAction(() -> controller.fieldClickCallback(row, col));

                field[i][j] = tmp;

                addChild(tmp);
            }
        }
    }


    @Override
    public void receiveNotification(INotification n) {

    }
}
