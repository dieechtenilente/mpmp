package view;

import java.awt.Point;

import model.Field;

/**
 * Converter converts the position of a field to the left upper corner pixel of that field
 * relative to the gameboard. wfld and hfld are the width and height of an unrotated field
 * in pixels.
 */
public class Converter {
	private Point pos2xypx[];
	private int hfld;
	private int wfld;

