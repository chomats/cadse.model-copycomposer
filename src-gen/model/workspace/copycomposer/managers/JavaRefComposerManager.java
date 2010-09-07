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
 * 
 * Copyright (C) 2006-2010 Adele Team/LIG/Grenoble University, France
 */
package model.workspace.copycomposer.managers;

import java.util.List;

import model.workspace.copycomposer.CopyComposerCST;
import fr.imag.adele.cadse.cadseg.managers.build.ComposerManager;
import fr.imag.adele.cadse.core.CadseException;
import fr.imag.adele.cadse.core.Item;
import fr.imag.adele.cadse.core.ItemType;
import fr.imag.adele.cadse.core.Link;
import fr.imag.adele.cadse.core.LinkType;
import fr.imag.adele.cadse.core.Validator;
import fr.imag.adele.cadse.core.util.Convert;

/**
 * @generated
 */
/**
 * @author vega
 *
 */
public class JavaRefComposerManager extends ComposerManager {

	// private static final String HAS_CLASSES_ATTRIBUTE = "has-classes";
	// private static final String HAS_ASPECTS_ATTRIBUTE = "has-aspect";
	// private static final String HAS_SOURCES_ATTRIBUTE = "has-sources";
	// private static final String FOLDER_SOURCES_ATTRIBUTE = "folder-sources";
	// private static final String FOLDER_CLASSES_ATTRIBUTE = "folder-classes";



	public JavaRefComposerManager() {
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
	 * Validate there is only one JavaRefComposer associated with a composite.
	 * 
	 * @see fr.imag.adele.cadse.core.DefaultItemManager#canCreateMeItem(fr.imag.adele.cadse.core.Item, fr.imag.adele.cadse.core.LinkType, fr.imag.adele.cadse.core.ItemType)
	 */
	@Override
	public String canCreateMeItem(Item itemParent, LinkType lt,ItemType destType) {
		for (Item existingComposer : itemParent.getOutgoingItems(lt,true)) {
			if (existingComposer.isInstanceOf(CopyComposerCST.JAVA_REF_COMPOSER))
				return "Java content composer already added";
		}
		
		return null;
	}

	/**
	 * @generated
	 */
	public static final boolean isHasClassesAttribute(final Item javaRefComposer) {
		return javaRefComposer.getAttributeWithDefaultValue(CopyComposerCST.JAVA_REF_COMPOSER_at_HAS_CLASSES_, true);
	}

	/**
	 * @generated
	 */
	public static final void setHasClassesAttribute(final Item javaRefComposer, final boolean value) {
		try {
			javaRefComposer.setAttribute(CopyComposerCST.JAVA_REF_COMPOSER_at_HAS_CLASSES_, value);
		} catch (Throwable t) {

		}
	}

	/**
	 * @generated
	 */
	public static final boolean isHasAspectAttribute(final Item javaRefComposer) {
		return javaRefComposer.getAttributeWithDefaultValue(CopyComposerCST.JAVA_REF_COMPOSER_at_HAS_ASPECT_, null);
	}

	/**
	 * @generated
	 */
	public static final void setHasAspectAttribute(final Item javaRefComposer, final boolean value) {
		try {
			javaRefComposer.setAttribute(CopyComposerCST.JAVA_REF_COMPOSER_at_HAS_ASPECT_, value);
		} catch (Throwable t) {

		}
	}

	/**
	 * @generated
	 */
	public static final boolean isHasSourcesAttribute(final Item javaRefComposer) {
		return javaRefComposer.getAttributeWithDefaultValue(CopyComposerCST.JAVA_REF_COMPOSER_at_HAS_SOURCES_, false);
	}

	/**
	 * @generated
	 */
	public static final void setHasSourcesAttribute(final Item javaRefComposer, final boolean value) {
		try {
			javaRefComposer.setAttribute(CopyComposerCST.JAVA_REF_COMPOSER_at_HAS_SOURCES_, value);
		} catch (Throwable t) {

		}
	}

	/**
	 * @generated
	 */
	public static final String getFolderSourcesAttribute(final Item javaRefComposer) {
		return javaRefComposer.getAttributeWithDefaultValue(CopyComposerCST.JAVA_REF_COMPOSER_at_FOLDER_SOURCES_, null);
	}

	/**
	 * @generated
	 */
	public static final void setFolderSourcesAttribute(final Item javaRefComposer, final String value) {
		try {
			javaRefComposer.setAttribute(CopyComposerCST.JAVA_REF_COMPOSER_at_FOLDER_SOURCES_, value);
		} catch (Throwable t) {

		}
	}

	/**
	 * @generated
	 */
	public static final String getFolderClassesAttribute(final Item javaRefComposer) {
		return javaRefComposer.getAttributeWithDefaultValue(CopyComposerCST.JAVA_REF_COMPOSER_at_FOLDER_CLASSES_, null);
	}

	/**
	 * @generated
	 */
	public static final void setFolderClassesAttribute(final Item javaRefComposer, final String value) {
		try {
			javaRefComposer.setAttribute(CopyComposerCST.JAVA_REF_COMPOSER_at_FOLDER_CLASSES_, value);
		} catch (Throwable t) {

		}
	}

	/**
		get a link 'contents' from 'JavaRefComposer' to 'ContentItem'.
		@generated
	*/
	static public Link getContentsLink(Item javaRefComposer) {
		return javaRefComposer.getOutgoingLink(CopyComposerCST.JAVA_REF_COMPOSER_lt_CONTENTS);
	}

	/**
		get all link destination 'contents' from 'JavaRefComposer' to 'ContentItem'.
		@generated
	*/
	static public Item getContentsAll(Item javaRefComposer) {
		return javaRefComposer.getOutgoingItem(CopyComposerCST.JAVA_REF_COMPOSER_lt_CONTENTS, false);
	}

	/**
		get resolved link destination 'contents' from 'JavaRefComposer' to 'ContentItem'.
		@generated
	*/
	static public Item getContents(Item javaRefComposer) {
		return javaRefComposer.getOutgoingItem(CopyComposerCST.JAVA_REF_COMPOSER_lt_CONTENTS, true);
	}

	/**
		set a link 'contents' from 'JavaRefComposer' to 'ContentItem'.
		@generated
	*/
	static public void setContents(Item javaRefComposer, Item value) throws CadseException {
		javaRefComposer.setOutgoingItem(CopyComposerCST.JAVA_REF_COMPOSER_lt_CONTENTS,value);
	}

	@Override
	public boolean mustBeExtended() {
		return false;
	}

	@Override
	public Class<?> getDefaultClassName() {
		return fede.workspace.eclipse.composition.copy.composer.CopyIntoFolderComposer.class;
	}

	@Override
	public boolean generateGetTargetMethod() {
		return false;
	}

	@Override
	public boolean callsuperPostCompose() {
		return true;
	}

	static public class JavaRefComposerValidator extends Validator {

		@Override
		public List<Item> validate(final Item item, final ProblemReporter reporter) {
			final boolean has_sources = hasSources(item);
			final boolean has_classes = hasClasses(item);
			final boolean has_aspects = hasAspects(item);
	
			if (!has_aspects && !has_classes && !has_sources) {
				reporter.error(item, 1, "Le composer doit avoir au moins un de ses flags � vrai");
			}
	
			return null;
		}
	}

	public static boolean hasSources(final Item item) {
		return Convert.toBoolean(item.getAttribute(CopyComposerCST.JAVA_REF_COMPOSER_at_HAS_SOURCES_), false);
		// return "true".equalsIgnoreCase( (String)
		// item.getAttribute(HAS_SOURCES_ATTRIBUTE));
	}

	public static boolean hasClasses(final Item item) {
		return Convert.toBoolean(item.getAttribute(CopyComposerCST.JAVA_REF_COMPOSER_at_HAS_CLASSES_), false);
		// return "true".equalsIgnoreCase( (String)
		// item.getAttribute(HAS_CLASSES_ATTRIBUTE));
	}

	public static boolean hasAspects(final Item item) {
		return Convert.toBoolean(item.getAttribute(CopyComposerCST.JAVA_REF_COMPOSER_at_HAS_ASPECT_), false);
		// return "true".equalsIgnoreCase( (String)
		// item.getAttribute(HAS_ASPECTS_ATTRIBUTE));
	}
}
