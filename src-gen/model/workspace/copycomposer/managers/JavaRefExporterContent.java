package model.workspace.copycomposer.managers;

import java.util.UUID;

import fr.imag.adele.cadse.cadseg.eclipse.content.build.exporter.ExporterContent;
import fr.imag.adele.cadse.core.CadseException;
import fr.imag.adele.cadse.core.GenStringBuilder;

/**
	@generated
*/
public class JavaRefExporterContent extends ExporterContent {

	/**
		@generated
	*/
	public JavaRefExporterContent(UUID id) throws CadseException {
		super(id);
	}

	@Override
	protected void generateConstrustorArguments(final GenStringBuilder sb) {
		sb.append("contentItem");
	}

	@Override
	protected void generateConstructorParameter(final GenStringBuilder sb) {
		sb.append("ContentItem contentItem");
	}
	
	@SuppressWarnings("hiding")
	public static final String	DEFAUL_CLASS_NAME	= "fede.workspace.eclipse.composition.copy.exporter.JavaClassRefExporter";

	@Override
	public String getDefaultClassName() {
		return DEFAUL_CLASS_NAME;
	}

	@Override
	public boolean mustBeExtended() {
		return false;
	}
}