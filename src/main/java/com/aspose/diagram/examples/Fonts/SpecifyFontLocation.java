package com.aspose.diagram.examples.Fonts;

import com.aspose.diagram.Diagram;
import com.aspose.diagram.SaveFileFormat;
import com.aspose.diagram.examples.Utils;
import com.aspose.diagram.examples.ExternalDataSources.EditDataConAndRefreshRecords;

public class SpecifyFontLocation {

	public static void main(String[] args) throws Exception {
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(SpecifyFontLocation.class) + "Fonts/";

		String[] fontDirs = new String[] { "C:\\MyFonts\\", "D:\\Misc\\Fonts\\" };
		// Load the Visio diagram
		Diagram diagram = new Diagram(dataDir + "Drawing1.vsdx");
		// setting the custom font directories
		diagram.setFontDirs(fontDirs);

		// saving Visio diagram in PDF format
		diagram.save(dataDir + "SetFontsFolders_Out.pdf", SaveFileFormat.PDF);
	}

}
