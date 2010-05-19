package model.workspace.copycomposer.managers;

import java.util.Set;
import java.util.UUID;

import model.workspace.copycomposer.CopyComposerCST;
import fr.imag.adele.cadse.cadseg.eclipse.content.build.ComposerContent;
import fr.imag.adele.cadse.core.CadseException;
import fr.imag.adele.cadse.core.GenContext;
import fr.imag.adele.cadse.core.GenStringBuilder;

/**
	@generated
*/
public class JavaRefComposerContent extends ComposerContent {

	/**
		@generated
	*/
	public JavaRefComposerContent(UUID id) throws CadseException {
		super(id);
	}

	@Override
	public void computeImportsPackage(final Set<String> imports) {
		super.computeImportsPackage(imports);

		imports.add("org.eclipse.core.runtime");
		final boolean has_sources = JavaRefComposerManager.hasSources(getOwnerItem());
		final boolean has_classes = JavaRefComposerManager.hasClasses(getOwnerItem());

		if (has_classes || has_sources) {
			imports.add("fede.workspace.eclipse.composition.copy.composer");
		}
	}

	@Override
	public void generate(final GenStringBuilder sb, final String type, final String kind,
			final Set<String> imports, final GenContext context) {

		final boolean has_sources = JavaRefComposerManager.hasSources(getOwnerItem());
		final boolean has_classes = JavaRefComposerManager.hasClasses(getOwnerItem());
		final boolean has_aspects = JavaRefComposerManager.hasAspects(getOwnerItem());

		final String classcomposer = "fede.workspace.eclipse.composition.copy.composer.JavaClassesCopyComposer";
		String sourcecompser = "fede.workspace.eclipse.composition.copy.composer.JavaSourcesCopyComposer";
		final String ajsourcecompser = "fede.workspace.eclipse.composition.copy.composer.AspectJSourcesCopyComposer";
		if ("composers".equals(kind)) {


			final String classFolder = getOwnerItem().getAttribute(
					CopyComposerCST.JAVA_REF_COMPOSER_at_FOLDER_CLASSES_);

			boolean classFolderSpecified = (classFolder != null && classFolder.length()> 0);
			
			final String sourceFolder = getOwnerItem().getAttribute(
					CopyComposerCST.JAVA_REF_COMPOSER_at_FOLDER_SOURCES_);

			boolean sourceFolderSpecified = (sourceFolder != null || sourceFolder.length() > 0);
			
			// @changed
			if (has_classes) {
				sb.newline().append("new ").append(classcomposer).append(" (cm");
				if (classFolderSpecified) {
					sb.append(",\"").append(classFolder).append("\"");
					if (sourceFolderSpecified)
						sb.append(",\"").append(sourceFolder).append("\"");
				}
				
				sb.append("),");
				imports.add(classcomposer);
			}
			if (has_sources) {
				if (has_aspects) {
					sourcecompser = ajsourcecompser;
				}

				sb.newline().append("new ").append(sourcecompser).append(" (cm,").append(!has_classes);
				if (sourceFolderSpecified){
					sb.append(",\"").append(sourceFolder).append("\"");
				}
				
				sb.append("),");
				imports.add(sourcecompser);
			}

		}
	}
	
	@Override
	public boolean mustBeExtended() {
		return false;
	}

	@SuppressWarnings("hiding")
	public static final String	DEFAUL_CLASS_NAME	= "fede.workspace.eclipse.composition.copy.composer.CopyIntoFolderComposer";

	@Override
	public String getDefaultClassName() {
		return DEFAUL_CLASS_NAME;
	}

	@Override
	public boolean generateGetTargetMethod() {
		return false;
	}

	@Override
	public boolean callsuperPostCompose() {
		return true;
	}

}