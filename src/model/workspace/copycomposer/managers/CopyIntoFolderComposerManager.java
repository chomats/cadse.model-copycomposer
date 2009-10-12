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

import java.util.Collection;
import java.util.List;
import java.util.Set;

import model.workspace.copycomposer.CopyComposerCST;
import fede.workspace.eclipse.java.JavaIdentifier;
import fr.imag.adele.cadse.cadseg.ParseTemplate;
import fr.imag.adele.cadse.cadseg.exp.ParseException;
import fr.imag.adele.cadse.cadseg.managers.build.ComposerManager;
import fr.imag.adele.cadse.cadseg.managers.build.CompositeItemTypeManager;
import fr.imag.adele.cadse.cadseg.managers.build.composer.EclipseComposerManager;
import fr.imag.adele.cadse.core.CadseException;
import fr.imag.adele.cadse.core.CompactUUID;
import fr.imag.adele.cadse.core.ContentItem;
import fr.imag.adele.cadse.core.GenContext;
import fr.imag.adele.cadse.core.GenStringBuilder;
import fr.imag.adele.cadse.core.Item;
import fr.imag.adele.cadse.core.Link;
import fr.imag.adele.cadse.core.LinkType;

/**
 * @generated
 */
public class CopyIntoFolderComposerManager extends EclipseComposerManager {

	/**
	 * @generated
	 */
	public class MyContentItem extends ComposerManager.ComposerContent {

		/**
		 * @generated
		 */
		public MyContentItem(CompactUUID id) throws CadseException {
			super(id);
		}

		private String escapeBackSlashes(final String str) {
			return str.replaceAll("\\\\", "\\\\");
		}

		@Override
		public void computeImportsPackage(final Set<String> imports) {
			super.computeImportsPackage(imports);

			imports.add("org.eclipse.core.runtime");
		}

		@Override
		public void generate(final GenStringBuilder sb, final String type, final String kind,
				final Set<String> imports, final GenContext context) {
			final String defaultQualifiedClassName = getDefaultClassName();
			String defaultClassName = JavaIdentifier.getlastclassName(defaultQualifiedClassName);

			if ("inner-class".equals(kind)) {
				imports.add("fr.imag.adele.cadse.core.Item");
				imports.add("fr.imag.adele.cadse.core.CadseException");
				imports.add(defaultQualifiedClassName);
				final boolean extendsClass = mustBeExtended() || isExtendsClass(getItem());
				if (extendsClass) {

					final String extendsClassName = defaultClassName;
					defaultClassName = JavaIdentifier.javaIdentifierFromString(getItem().getName(), true, false,
							"Composer");
					sb.newline();
					sb.newline().append("/**");
					sb.newline().append("	@generated");
					sb.newline().append("*/");
					sb.newline().append("public class ").append(defaultClassName).append(" extends ").append(
							extendsClassName).append(" {");
					sb.begin();
					sb.newline();
					sb.newline().append("/**");
					sb.newline().append("	@generated");
					sb.newline().append("*/");
					sb.newline().append("public ").append(defaultClassName).append(" (");
					generateConstructorParameter(sb);
					sb.decrementLength();
					sb.append(") {");
					sb.newline().append("	super(");
					generateConstrustorArguments(sb);
					sb.decrementLength();
					sb.append(");");
					sb.newline().append("}");

					imports.add("fr.imag.adele.cadse.core.build.IExporterTarget");

					if (generateGetTargetMethod()) {
						sb.newline();
						sb.newline().append("@Override");
						sb.newline().append("protected IExporterTarget getTarget() {");
						sb.newline().append("	// TODO Auto-generated method stub");
						sb.newline().append("	return null;");
						sb.newline().append("}");

					}

					sb.newline();
					sb.newline().append("@Override");
					sb.newline().append("protected void postCompose(IBuildingContext context,");
					sb.newline().append("		List<IExportedContent> listExportedContent,");
					sb.newline().append("		IExporterTarget target) {");
					sb.newline().append("	// TODO Auto-generated method stub");
					sb.newline().append("	super.postCompose(context, listExportedContent, target);");
					sb.newline().append("}");

					// @added begin
					generateOtherMethods(sb, imports, context);
					// @added end

					sb.end();

					sb.newline().append("}");

					imports.add("java.util.List");
					imports.add("fr.imag.adele.cadse.core.build.Composer");
					imports.add("fr.imag.adele.cadse.core.build.IBuildingContext");
					imports.add("fr.imag.adele.cadse.core.build.IExportedContent");

				}
			}

			if ("composers".equals(kind)) {
				final boolean extendsClass = mustBeExtended() || isExtendsClass(getItem());

				if (extendsClass) {
					defaultClassName = JavaIdentifier.javaIdentifierFromString(getItem().getName(), true, false,
							"Composer");
				}

				// @changed
				sb.newline().append("new ").append(defaultClassName).append(" (cm,");
				generateCallArguments(sb, imports, context);
				sb.decrementLength();
				sb.append("),");
			}
		}

		@Override
		protected void generateCallArguments(final GenStringBuilder sb, final Set<String> imports,
				final GenContext context) {

			sb.appendStringValue(getItem().getName()).append(", ");

			super.generateCallArguments(sb, imports, context);
		}

		@Override
		protected void generateConstrustorArguments(final GenStringBuilder sb) {
			sb.newline().append("contentItem, name, exporterTypes,");
		}

		@Override
		protected void generateConstructorParameter(final GenStringBuilder sb) {
			sb.append("ContentItem contentItem, String name, String... exporterTypes,");
		}

		/**
		 * @Added
		 */
		@Override
		protected void generateOtherMethods(final GenStringBuilder sb, final Set<String> imports,
				final GenContext context) {

			generateAcceptsMethod(sb, imports);
			generateGetTargetPathMethod(sb, imports);
		}

		private void generateAcceptsMethod(final GenStringBuilder sb, final Set<String> imports) {
			final Collection<Item> acceptLinkTypes = getItem().getOutgoingItems(
					CopyComposerCST.COPY_INTO_FOLDER_COMPOSER_lt_MANAGES_LT, true);

			if (acceptLinkTypes.size() == 0) {
				return;
			}

			sb.newline();
			sb.appendGeneratedTag();
			sb.newline().append("@Override");

			imports.add("fr.imag.adele.cadse.core.Link");

			sb.newline().append("protected boolean accepts(Link l) {");
			sb.begin();
			sb.newline().append("// Don't remove this line, necessary for link management !!!");
			sb.newline().append("super.accepts(l);");
			sb.newline();
			sb.newline().append("String linkTypeName = l.getLinkType().getName();");

			imports.add("java.util.List");
			imports.add("java.util.ArrayList");

			sb.newline().append("List<String> linkTypeNames = new ArrayList<String>();");

			// Retrieve all managed link types
			for (final Item item : acceptLinkTypes) {
				sb.newline().append("linkTypeNames.add(\"" + escapeBackSlashes(item.getName()) + "\");");
			}

			sb.newline();
			sb.newline().append("return linkTypeNames.contains(linkTypeName);");
			sb.end();
			sb.newline().append("}");
			sb.newline();
		}

		private void generateGetTargetPathMethod(final GenStringBuilder sb, final Set<String> imports) {
			sb.newline();
			sb.appendGeneratedTag();
			sb.newline().append("@Override");

			imports.add("org.eclipse.core.runtime.IPath");

			sb.newline().append("public IPath getTargetPath() {");
			sb.begin();
			sb.newline();

			// Generate evaluation of folder path attribute value expresion
			String value = getItem().getAttribute(CopyComposerCST.COPY_INTO_FOLDER_COMPOSER_at_TARGET_FOLDER);
			if (value == null || value.length() == 0) {
				value = "";
			}

			final Item compositeItem = getItem().getPartParent();
			final Item itemtype = CompositeItemTypeManager.getItemType(compositeItem);
			final ParseTemplate pt = new ParseTemplate(itemtype, value, null);
			try {
				pt.main();
				pt.build("getItem()", "sb", sb, imports, null);
			} catch (final ParseException e) {
				e.printStackTrace();
			} catch (final Exception ex) {
				ex.printStackTrace();
			}

			imports.add("org.eclipse.core.runtime.Path");

			sb.newline();
			sb.newline().append("return new Path(sb.toString());");
			sb.end();
			sb.newline().append("}");
			sb.newline();
		}

	}

	public CopyIntoFolderComposerManager() {
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
	@Override
	public ContentItem createContentItem(CompactUUID id) throws CadseException {
		MyContentItem cm = new MyContentItem(id);
		cm.setComposers();
		cm.setExporters();
		return cm;
	}

	@Override
	public boolean mustBeExtended() {
		return true;
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

	@Override
	public List<Item> validate(final Item item, final ProblemReporter reporter) {
		String value = item.getAttribute(CopyComposerCST.COPY_INTO_FOLDER_COMPOSER_at_TARGET_FOLDER_);
		if (value == null || value.length() == 0) {
			value = "";
		}
		final Item compositeItemType = item.getPartParent();
		final Item itemtype = CompositeItemTypeManager.getItemType(compositeItemType);
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
				reporter.error(item, 0, "Error when parse target folder name value : {0} ", e.getMessage());
			}

		}
		return super.validate(item, reporter);
	}

	/**
	 * @generated
	 */
	public static final String getTargetFolderAttribute(final Item copyIntoFolderComposer) {
		return copyIntoFolderComposer.getAttributeWithDefaultValue(
				CopyComposerCST.COPY_INTO_FOLDER_COMPOSER_at_TARGET_FOLDER_, "null");
	}

	/**
	 * @generated
	 */
	public static final void setTargetFolderAttribute(final Item copyIntoFolderComposer, final String value) {
		try {
			copyIntoFolderComposer.setAttribute(CopyComposerCST.COPY_INTO_FOLDER_COMPOSER_at_TARGET_FOLDER_, value);
		} catch (Throwable t) {

		}
	}

	/**
	 * get links 'managesLT' from 'CopyIntoFolderComposer' to 'Link'.
	 * 
	 * @generated
	 */
	static public List<Link> getManagesLTLink(final Item copyIntoFolderComposer) {
		return copyIntoFolderComposer.getOutgoingLinks(CopyComposerCST.COPY_INTO_FOLDER_COMPOSER_lt_MANAGES_LT);
	}

	/**
	 * @generated
	 */
	static public Collection<Item> getManagesLTAll(final Item copyIntoFolderComposer) {
		return copyIntoFolderComposer.getOutgoingItems(CopyComposerCST.COPY_INTO_FOLDER_COMPOSER_lt_MANAGES_LT, false);
	}

	/**
	 * @generated
	 */
	static public Collection<Item> getManagesLT(final Item copyIntoFolderComposer) {
		return copyIntoFolderComposer.getOutgoingItems(CopyComposerCST.COPY_INTO_FOLDER_COMPOSER_lt_MANAGES_LT, true);
	}

	/**
	 * @generated
	 */
	static public void addManagesLT(final Item copyIntoFolderComposer, final Item value) throws CadseException {
		copyIntoFolderComposer.addOutgoingItem(CopyComposerCST.COPY_INTO_FOLDER_COMPOSER_lt_MANAGES_LT, value);
	}

	/**
	 * @generated
	 */
	static public void removeManagesLT(final Item copyIntoFolderComposer, final Item value) throws CadseException {
		copyIntoFolderComposer.removeOutgoingItem(CopyComposerCST.COPY_INTO_FOLDER_COMPOSER_lt_MANAGES_LT, value);
	}
}
