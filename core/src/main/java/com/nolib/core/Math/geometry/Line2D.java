package com.nolib.core.Math.geometry;

import com.nolib.core.Math.positions.Point;

public class Line2D {

    double intercept;
    double slope;

    double interceptX;
    boolean vertical;

    public Line2D(double slope, double intercept) {
        this.slope = slope;
        this.intercept = intercept;
    }
    public Line2D(Point point1, Point point2) {
        if(point1.x != point2.x) {
            slope = (point2.y - point1.y) / (point2.x - point1.x);
            intercept = point1.y - (point1.x * slope);
        }
    }
    public Line2D(Point point, double slope) {
        this.slope = slope;
        intercept = point.y - (point.x * slope);
    }

    public void setLine(double slope, double intercept) {
        this.slope = slope;
        this.intercept = intercept;
    }
    public void setLine(Point point1, Point point2) {
        if(point1.x != point2.x) {
            slope = (point2.y - point1.y) / (point2.x - point1.x);
            intercept = point1.y - (point1.x * slope);
        } else {
            vertical = true;
            interceptX = point1.x;
        }
    }
    public void setLine(Point point, double slope) {
        this.slope = slope;
        intercept = point.y - (point.x * slope);
    }
    public void setVerticalLine(double xIntercept) {
        interceptX = xIntercept;
        vertical = true;
    }

    public Point intersection(Line2D line) {
        /*y = ax + b;
        y = cx + d;
        (ax + b) - (cx + d) = 0;
        ax + b - cx - d = 0;
        ax - cx = d - b
        x(a - c) = d - b
        x = (d - b) / (a - c)
         */
        if(this.slope != line.slope || this.vertical || line.vertical) {
            double x;
            double y;

            if(!this.vertical && !line.vertical) {
                x = (intercept - line.intercept) / (line.slope - slope);
                y = slope * x + intercept;
            }
            else if(this.vertical) {
                x = this.interceptX;
                y = line.intercept + line.slope * x;
            }
            else {
                x = line.interceptX;
                y = this.intercept + line.slope * x;
            }

            return new Point(x, y);

        } else {
            return null;
        }
    }

    public Point intersection(Line2D line, double theta) {
        /*y = ax + b;
        y = cx + d;
        (ax + b) - (cx + d) = 0;
        ax + b - cx - d = 0;
        ax - cx = d - b
        x(a - c) = d - b
        x = (d - b) / (a - c)
         */
        if(this.slope != line.slope || this.vertical || line.vertical) {
            double x;
            double y;

            if(!this.vertical && !line.vertical) {
                x = (intercept - line.intercept) / (line.slope - slope);
                y = slope * x + intercept;
            }
            else if(this.vertical) {
                x = this.interceptX;
                y = line.intercept + line.slope * x;
            }
            else {
                x = line.interceptX;
                y = this.intercept + line.slope * x;
            }

            return new Point(x, y, theta);

        } else {
            return null;
        }
    }

}
