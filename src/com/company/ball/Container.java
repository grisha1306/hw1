package com.company.ball;

public class Container {
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public Container(int x, int y, int width, int height){
        this.x1 = x;
        this.y1 = y;
        this.x2 = x1 + width - 1;
        this.y2 = y1 - height + 1;
    }

    public int getX() {
        return x1;
    }

    public int getY() {
        return y1;
    }

    public int getWidth() {
        return (this.x2 - this.x1 - 1);
    }
    public int getHeight() {
        return (this.y2 - this.y1 - 1);
    }

    public boolean collidesWith(Ball ball)
    {
        float xLeft = ball.getX() - ball.getRadius();
        float xRight = ball.getX() + ball.getRadius();
        float yDown = ball.getY() - ball.getRadius();
        float yUp = ball.getY() + ball.getRadius();

        if (xLeft >= this.x1 && xRight <= this.x2 && yDown >= this.y2 && yUp <= this.y1)
            return true;
        else if (xLeft >= this.x1 && xRight <= this.x2) {

            if( yDown <= this.y2 )
                ball.setY(yDown - ball.getYDelta());
            else if ( yUp >= this.y1 )
                ball.setY(yUp - ball.getYDelta() - ball.getRadius());

            ball.reflectVertical();
            return false;
        }

        else if (yDown >= this.y2 && yUp <= this.y1)  {

            if( xLeft <= this.x1 )
                ball.setX(xLeft + ball.getXDelta());
            else if ( xRight >= this.x2 )
                ball.setX(xRight - ball.getXDelta() - ball.getRadius());

            ball.reflectHorizontal();
            return false;
        }

        else
            return false;
    }

    public String toString() {
        return "Container at ("+ x1 +","+ y1 +") to ("+ x2 +", "+ y2 +")";
    }

}
