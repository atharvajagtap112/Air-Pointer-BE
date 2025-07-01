package com.atharva.airpointerbe.Model;



public class MotionData {
    private double dx;
    private double dy;
    private String action;
    private double scroll_dy;
    public MotionData() {}

    public MotionData(double dx, double dy, String action, double scroll_dy ) {
        this.dx = dx;
        this.action=action;
        this.scroll_dy=scroll_dy;
        this.dy = dy;
    }

    public double getScroll_dy() {
        return scroll_dy;
    }

    public void setScroll_dy(double scroll_dy) {
        this.scroll_dy = scroll_dy;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }
}
