package com.aspose.diagram.examples.LoadSaveConvert;

import com.aspose.diagram.Diagram;
import com.aspose.diagram.SaveFileFormat;
import com.aspose.diagram.examples.Utils;
import com.aspose.diagram.examples.License.ApplyLicenseUsingFileStream;

public class CreateNewVisio {

	public static void main(String[] args) throws Exception {
		// ExStart:CreateNewVisio
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(CreateNewVisio.class) + "LoadSaveConvert/";
		// initialize a Diagram class
		Diagram diagram = new Diagram();

		// save diagram in the VSDX format
		diagram.save(dataDir + "CreateNewVisio_Out.vsdx", SaveFileFormat.VSDX);
		// ExEnd:CreateNewVisio
	}

}
