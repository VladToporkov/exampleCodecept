package com.actionmedia.autotest.imagecomparison;

import java.awt.*;

/**
 * User: n.tyukavkin
 * Date: 24.07.2014
 * Time: 21:26
 */
public interface IContour {

    Rectangle getRectangle();

    void add(Point startAt);
}
