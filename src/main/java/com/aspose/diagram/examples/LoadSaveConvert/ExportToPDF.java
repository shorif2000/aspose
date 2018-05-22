/*
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Diagram. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

package com.aspose.diagram.examples.LoadSaveConvert;

import com.aspose.diagram.*;
import com.aspose.diagram.examples.Utils;

public class ExportToPDF {
	public static void main(String[] args) throws Exception {
		// ExStart:ExportToPDF
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(ExportToPDF.class) + "LoadSaveConvert/";

		// Call the diagram constructor to load diagram from a VSD file
		Diagram diagram = new Diagram(dataDir + "ExportToPDF.vsd");

		// Save as PDF file format
		diagram.save(dataDir + "ExportToPDF_Out.pdf", SaveFileFormat.PDF);
		// ExEnd:ExportToPDF
	}
}
