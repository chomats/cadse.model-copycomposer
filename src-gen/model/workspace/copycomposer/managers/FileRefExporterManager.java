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

import fede.workspace.eclipse.content.SubFileContentManager;
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
import java.util.UUID;
import fr.imag.adele.cadse.core.content.ContentItem;
import fr.imag.adele.cadse.core.util.Convert;
import fr.imag.adele.cadse.core.var.ContextVariable;
import fr.imag.adele.cadse.core.var.Variable;
import java.lang.String;
import fr.imag.adele.cadse.core.GenContext;
import fr.imag.adele.cadse.core.GenStringBuilder;
import fr.imag.adele.cadse.core.Item;
import fr.imag.adele.cadse.core.ItemType;
import fr.imag.adele.cadse.core.Link;
import fr.imag.adele.cadse.core.LinkType;

/**
 * @generated
 */
public class FileRefExporterManager extends ExporterManager {

	/**
		@generated
	*/
	public class FileRefExporterContent extends ExporterManager.ExporterContent {

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
				final boolean extendsClass = mustBeExtended() || isExtendsClass(getOwnerItem());

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
				final boolean extendsClass = mustBeExtended() || isExtendsClass(getOwnerItem());

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

	}

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
	public String computeQualifiedName(final Item item, final String name, final Item parent, final LinkType lt) {
		StringBuilder sb = new StringBuilder();
		try {
			Object value;
			Item currentItem;
			if (parent != null) {
				sb.append(parent.getQualifiedName());
			}
			if (sb.length() != 0) {
				sb.append(".");
			}
			sb.append(name);
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
			if (item != null) {
				return item.getName();
			}
			return "";
		} catch (Throwable e) {
			e.printStackTrace();
			return "error";
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
	public ContentItem createContentItem(UUID id, Item owerItem) throws CadseException {
		FileRefExporterContent cm = new FileRefExporterContent(
			id
			);
		owerItem.setComposers(
		);
		owerItem.setExporters(
		);
		return cm;
	}
	
	/**
	 * @generated
	 */
	public static final String getExportedFolderAttribute(final Item fileRefExporter) {
		return fileRefExporter.getAttributeWithDefaultValue(CopyComposerCST.FILE_REF_EXPORTER_at_EXPORTED_FOLDER_, null);
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

	/**
		get a link 'contents' from 'FileRefExporter' to 'ContentItem'.
		@generated
	*/
	static public Link getContentsLink(Item fileRefExporter) {
		return fileRefExporter.getOutgoingLink(CopyComposerCST.FILE_REF_EXPORTER_lt_CONTENTS);
	}

	/**
		get all link destination 'contents' from 'FileRefExporter' to 'ContentItem'.
		@generated
	*/
	static public Item getContentsAll(Item fileRefExporter) {
		return fileRefExporter.getOutgoingItem(CopyComposerCST.FILE_REF_EXPORTER_lt_CONTENTS, false);
	}

	/**
		get resolved link destination 'contents' from 'FileRefExporter' to 'ContentItem'.
		@generated
	*/
	static public Item getContents(Item fileRefExporter) {
		return fileRefExporter.getOutgoingItem(CopyComposerCST.FILE_REF_EXPORTER_lt_CONTENTS, true);
	}

	/**
		set a link 'contents' from 'FileRefExporter' to 'ContentItem'.
		@generated
	*/
	static public void setContents(Item fileRefExporter, Item value) throws CadseException {
		fileRefExporter.setOutgoingItem(CopyComposerCST.FILE_REF_EXPORTER_lt_CONTENTS,value);
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
		String value = item.getAttribute(CopyComposerCST.FILE_REF_EXPORTER_at_EXPORTED_FOLDER_);
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
