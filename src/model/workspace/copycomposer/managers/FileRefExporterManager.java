/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package model.workspace.copycomposer.managers;

import java.util.List;
import java.util.Set;

import model.workspace.copycomposer.CopyComposerCST;
import fede.workspace.eclipse.java.JavaIdentifier;
import fede.workspace.eclipse.java.manager.JavaFileContentManager;
import fr.imag.adele.cadse.cadseg.ParseTemplate;
import fr.imag.adele.cadse.cadseg.exp.ParseException;
import fr.imag.adele.cadse.cadseg.managers.build.exporter.ExporterManager;
import fr.imag.adele.cadse.cadseg.managers.content.ManagerManager;
import fr.imag.adele.cadse.cadseg.managers.dataModel.ItemTypeManager;
import fr.imag.adele.cadse.core.CadseException;
import fr.imag.adele.cadse.core.CompactUUID;
import fr.imag.adele.cadse.core.ContentItem;
import fr.imag.adele.cadse.core.GenContext;
import fr.imag.adele.cadse.core.GenStringBuilder;
import fr.imag.adele.cadse.core.Item;
import fr.imag.adele.cadse.core.LinkType;

/**
 * @generated
 */
public class FileRefExporterManager extends ExporterManager {

	/**
	 * @generated
	 */
	public FileRefExporterManager() {
		super();
	}

	/**
	 * @generated
	 */
	@Override
	public String computeQualifiedName(final Item item, final String shortName, final Item parent, final LinkType lt) {
		StringBuilder sb = new StringBuilder();
		try {
			Object value;
			sb.append(parent.getQualifiedName());
			if (sb.length() != 0) {
				sb.append(".");
			}
			sb.append(shortName);
			return sb.toString();
		} catch (Throwable e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * @generated
	 */
	@Override
	public String getDisplayName(final Item item) {
		try {
			Object value;
			Item currentItem;
			return item.getName();
		} catch (Throwable e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * @generated
	 */
	public class MyContentItem extends ExporterManager.ExporterContent {

		/**
		 * @generated
		 */
		public MyContentItem(CompactUUID id) throws CadseException {
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
				final boolean extendsClass = mustBeExtended() || isExtendsClass(getItem());

				if (extendsClass) {

					String extendsClassName = defaultClassName;
					defaultClassName = JavaIdentifier.javaIdentifierFromString(getItem().getName(), true, false,
							"Exporter");

					final Item manager = getItem().getPartParent();

					final Item itemtype = ManagerManager.getItemType(manager);

					final Item superitemtype = ItemTypeManager.getSuperType(itemtype);
					if (superitemtype != null) {
						final Item superItemManager = ItemTypeManager.getManager(superitemtype);
						final Item supercontentItem = ManagerManager.getContentModel(superItemManager);
						if (supercontentItem != null) {
							if (isExtendsClass(supercontentItem)) {
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
				final boolean extendsClass = mustBeExtended() || isExtendsClass(getItem());

				if (extendsClass) {
					defaultClassName = JavaIdentifier.javaIdentifierFromString(getItem().getName(), true, false,
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
			String value = getItem().getAttribute(CopyComposerCST.FILE_REF_EXPORTER_at_EXPORTED_FOLDER_);
			if (value == null || value.length() == 0) {
				value = "";
			}
			final Item itemtype = ManagerManager.getItemType(getItem().getPartParent());
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
	}

	/**
	 * @Added
	 */
	public boolean mustExtendExportItemMethod() {
		return false;
	}

	/**
	 * @generated
	 */
	@Override
	public ContentItem createContentItem(CompactUUID id) throws CadseException {
		MyContentItem cm = new MyContentItem(id);
		cm.setComposers();
		cm.setExporters();
		return cm;
	}
	
	/**
	 * @generated
	 */
	public static final String getExportedFolderAttribute(final Item fileRefExporter) {
		return fileRefExporter.getAttributeWithDefaultValue(CopyComposerCST.FILE_REF_EXPORTER_at_EXPORTED_FOLDER_,
				"null");
	}

	/**
	 * @generated
	 */
	public static final void setExportedFolderAttribute(final Item fileRefExporter, final String value) {
		try {
			fileRefExporter.setAttribute(CopyComposerCST.FILE_REF_EXPORTER_at_EXPORTED_FOLDER_, value);
		} catch (Throwable t) {

		}
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

	@Override
	public List<Item> validate(final Item item, final ProblemReporter reporter) {
		String value = item.getAttribute(CopyComposerCST.FILE_REF_EXPORTER_at_EXPORTED_FOLDER);
		if (value == null || value.length() == 0) {
			value = "";
		}
		final Item itemtype = ManagerManager.getItemType(item.getPartParent());
		O: {
			if (itemtype == null) {
				reporter.error(item, 1, "Item type is null");
				break O;
			}
			final ParseTemplate pt = new ParseTemplate(itemtype, value, null);
			try {
				pt.main();
				pt.validate(reporter, item);
			} catch (final ParseException e) {
				reporter.error(item, 0, "Error when parse exported folder name value : {0} ", e.getMessage());
			}

		}
		return super.validate(item, reporter);
	}
}
