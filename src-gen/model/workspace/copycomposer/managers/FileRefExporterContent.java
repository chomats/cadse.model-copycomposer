package model.workspace.copycomposer.managers;

import java.util.Set;
import java.util.UUID;

import model.workspace.copycomposer.CopyComposerCST;
import fede.workspace.eclipse.java.JavaIdentifier;
import fede.workspace.eclipse.java.manager.JavaFileContentManager;
import fr.imag.adele.cadse.cadseg.eclipse.ParseTemplate;
import fr.imag.adele.cadse.cadseg.eclipse.content.build.exporter.ExporterContent;
import fr.imag.adele.cadse.cadseg.exp.ParseException;
import fr.imag.adele.cadse.cadseg.managers.content.ManagerManager;
import fr.imag.adele.cadse.cadseg.managers.dataModel.ItemTypeManager;
import fr.imag.adele.cadse.core.CadseException;
import fr.imag.adele.cadse.core.GenContext;
import fr.imag.adele.cadse.core.GenStringBuilder;
import fr.imag.adele.cadse.core.Item;

/**
	@generated
*/
public class FileRefExporterContent extends ExporterContent {

	/**
		@generated
	*/
	public FileRefExporterContent(UUID id) throws CadseException {
		super(id);
	}
	
	@Override
	protected void generateConstrustorArguments(final GenStringBuilder sb) {
		sb.append("contentManager,null,null,exportTypes");
	}

	@Override
	protected void generateConstructorParameter(final GenStringBuilder sb) {
		sb.append("ContentItem contentManager, String... exportTypes");
	}

	@Override
	public void generate(final GenStringBuilder sb, final String type, final String kind,
			final Set<String> imports, final GenContext context) {
		// ItemType it = getItem().getType();
		final String defaultQualifiedClassName = getDefaultClassName();
		String defaultClassName = JavaIdentifier.getlastclassName(defaultQualifiedClassName);

		if ("inner-class".equals(kind)) {
			generateParts(sb, type, kind, imports, null);
			final boolean extendsClass = mustBeExtended() || FileRefExporterManager.isExtendsClass(getOwnerItem());

			if (extendsClass) {

				String extendsClassName = defaultClassName;
				defaultClassName = JavaIdentifier.javaIdentifierFromString(getOwnerItem().getName(), true, false,
						"Exporter");

				final Item manager = getOwnerItem().getPartParent();

				final Item itemtype = ManagerManager.getItemType(manager);

				final Item superitemtype = ItemTypeManager.getSuperType(itemtype);
				if (superitemtype != null) {
					final Item superItemManager = ItemTypeManager.getManager(superitemtype);
					final Item supercontentItem = ManagerManager.getContentModel(superItemManager);
					if (supercontentItem != null) {
						if (FileRefExporterManager.isExtendsClass(supercontentItem)) {
							extendsClassName = ((JavaFileContentManager) superItemManager.getContentItem())
									.getClassName(context)
									+ ".MyContentItem";
						}
					}
				}
				sb.newline();
				sb.appendGeneratedTag();
				sb.newline().append("public class ").append(defaultClassName).append(" extends ").append(
						extendsClassName).append(" {");
				sb.begin();
				sb.newline();
				sb.newline().append("/**");
				sb.newline().append("	@generated");
				sb.newline().append("*/");
				sb.newline().append("public ").append(defaultClassName).append("(");
				generateConstructorParameter(sb);
				sb.decrementLength();
				sb.append(") {");
				sb.newline().append("	super(");
				generateConstrustorArguments(sb);
				sb.decrementLength();
				sb.append(");");
				sb.newline().append("}");
				sb.end();
				// @Added begin
				if (mustExtendExportItemMethod()) {
					generateExportItemMethod(sb);
				}
				generateOtherMethods(sb, imports, context);
				// @Added end
				sb.newline().append("}");
				sb.newline();

				imports.add("fr.imag.adele.cadse.core.build.IBuildingContext");
				imports.add("fr.imag.adele.cadse.core.build.IExportedContent");
				imports.add("fr.imag.adele.cadse.core.build.IExporterTarget");

			}
		}
		if ("exporters".equals(kind)) {
			final boolean extendsClass = mustBeExtended() || FileRefExporterManager.isExtendsClass(getOwnerItem());

			if (extendsClass) {
				defaultClassName = JavaIdentifier.javaIdentifierFromString(getOwnerItem().getName(), true, false,
						"Exporter");
			}

			sb.newline().append("new ").append(defaultClassName).append("(cm,");
			generateCallArguments(sb, imports, null);
			sb.decrementLength();
			sb.append("),");

			imports.add("fr.imag.adele.cadse.core.Item");
			imports.add("fr.imag.adele.cadse.core.CadseException");
			imports.add(defaultQualifiedClassName);
			imports.add("fr.imag.adele.cadse.core.build.IExportedContent");
		}
	}

	/**
	 * @Added
	 */
	private void generateOtherMethods(final GenStringBuilder sb, final Set<String> imports, final GenContext context) {

		sb.newline();
		sb.begin();
		sb.appendGeneratedTag();
		sb.newline().append("@Override");

		imports.add("org.eclipse.core.resources.IFolder");

		sb.newline().append("protected IFolder getExportedFolder() {");
		sb.begin();
		sb.newline();

		// Generate evaluation of folder attribute value expresion
		String value = getOwnerItem().getAttribute(CopyComposerCST.FILE_REF_EXPORTER_at_EXPORTED_FOLDER_);
		if (value == null || value.length() == 0) {
			value = "";
		}
		final Item itemtype = ManagerManager.getItemType(getOwnerItem().getPartParent());
		final ParseTemplate pt = new ParseTemplate(itemtype, value, null);
		try {
			pt.main();
			pt.build("getItem()", "sb", sb, imports, null);
		} catch (final ParseException e) {
			e.printStackTrace();
		} catch (final Exception ex) {
			ex.printStackTrace();
		}

		// Append computation of folder
		imports.add("org.eclipse.core.resources.IProject");
		imports.add("fede.workspace.eclipse.MelusineProjectManager");
		sb.newline().append("IProject componentProject = " + "MelusineProjectManager.getProject(getItem());");

		sb.newline().append("return componentProject.getFolder(sb.toString());");
		sb.end();
		sb.newline().append("}");
		sb.newline();
		sb.end();
	}

	/**
	 * @Added
	 */
	private void generateExportItemMethod(final GenStringBuilder sb) {
		sb.newline().newline().append("@Override");
		sb.newline().append(
				"public IExportedContent exportItem(IBuildingContext context, "
						+ "IExporterTarget target, String exporterType) throws CadseException {");
		sb.newline().append("	// TODO Auto-generated method stub");
		sb.newline().append("	return null;");
		sb.newline().append("}");
		sb.newline();
	}

	@Override
	public void computeImportsPackage(final Set<String> imports) {
		super.computeImportsPackage(imports);

		imports.add("org.eclipse.core.resources");
		imports.add("fede.workspace.eclipse");
	}

	@Override
	protected void generateCallArguments(final GenStringBuilder sb, final Set<String> imports,
			final GenContext context) {
		// sb.append(" new Path(\"" + escapeBackSlashes((String)
		// getItem().getAttribute(EXPORTED_FOLDER_ATT_NAME)) + "\"),");

		// imports.add("org.eclipse.core.resources.IFolder");

		super.generateCallArguments(sb, imports, context);
	}

	/**
	 * @Added
	 */
	public boolean mustExtendExportItemMethod() {
		return false;
	}

	@SuppressWarnings("hiding")
	public static final String	DEFAUL_CLASS_NAME	= "fede.workspace.eclipse.composition.copy.exporter.FileRefExporter";

	@Override
	public String getDefaultClassName() {
		return DEFAUL_CLASS_NAME;
	}

	@Override
	public boolean mustBeExtended() {
		return true;
	}
}