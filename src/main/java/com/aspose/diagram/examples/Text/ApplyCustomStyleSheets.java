/*
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Diagram. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

package com.aspose.diagram.examples.Text;

import com.aspose.diagram.*;
import com.aspose.diagram.examples.Utils;
import com.aspose.diagram.examples.TechnicalArticles.AddConnectShapes;

public class ApplyCustomStyleSheets {
	public static void main(String[] args) throws Exception {
		// ExStart:ApplyCustomStyleSheets
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(ApplyCustomStyleSheets.class) + "Text/";

		// Load diagram
		Diagram diagram = new Diagram(dataDir + "ApplyCustomStyleSheets.vsd");
		Shape sourceShape = null;

		// get page by name
		Page page = diagram.getPages().getPage("Flow 1");
		// Find the shape that you want to apply style to
		for (com.aspose.diagram.Shape shape : (Iterable<Shape>) page.getShapes()) {
			if (shape.getName() == "Process") {
				sourceShape = shape;
				break;
			}
		}

		StyleSheet customStyleSheet = null;

		// Find the required style sheet
		for (StyleSheet styleSheet : (Iterable<StyleSheet>) diagram.getStyleSheets()) {
			if (styleSheet.getName() == "CustomStyle1") {
				customStyleSheet = styleSheet;
				break;
			}
		}

		if (sourceShape != null && customStyleSheet != null) {
			// Apply text style
			sourceShape.setTextStyle(customStyleSheet);
			// Apply fill style
			sourceShape.setFillStyle(customStyleSheet);
			// Apply line style
			sourceShape.setLineStyle(customStyleSheet);
		}

		// Save the changed diagram as VDX
		diagram.save(dataDir + "ApplyCustomStyleSheets_Out.vdx", SaveFileFormat.VDX);
		// ExEnd:ApplyCustomStyleSheets
	}
}
