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
package model.workspace.copycomposer.pages;

import fede.workspace.model.manager.properties.FieldsCore;
import model.workspace.copycomposer.CopyComposerCST;
import fede.workspace.model.manager.properties.impl.mc.StringToBooleanModelControler;
import fede.workspace.model.manager.properties.impl.ui.DCheckBoxUI;
import fede.workspace.model.manager.properties.impl.ui.DTextUI;
import fr.imag.adele.cadse.cadseg.pages.build.ComposerModificationPage1_ModificationPage;
import fr.imag.adele.cadse.core.IItemNode;
import fr.imag.adele.cadse.core.Item;
import fr.imag.adele.cadse.core.ItemType;
import fr.imag.adele.cadse.core.Link;
import fr.imag.adele.cadse.core.LinkType;
import fr.imag.adele.cadse.core.impl.ui.MC_AttributesItem;
import fr.imag.adele.cadse.core.impl.ui.PageImpl;
import fr.imag.adele.cadse.core.ui.EPosLabel;
import fr.imag.adele.cadse.core.ui.IActionPage;
import fr.imag.adele.cadse.core.ui.IPage;
import fr.imag.adele.cadse.core.ui.PageFactory;
import fr.imag.adele.cadse.core.ui.UIField;

/**
 * @generated
 */
public class JavaRefComposerModificationPage1_ModificationPage extends
		ComposerModificationPage1_ModificationPage {

	/**
	 * @generated
	 */
	protected DCheckBoxUI fieldHasClasses;

	/**
	 * @generated
	 */
	protected DCheckBoxUI fieldHasSources;

	/**
	 * @generated
	 */
	protected DTextUI fieldFolderSources;

	/**
	 * @generated
	 */
	protected DTextUI fieldFolderClasses;

	/**
	 * @generated
	 */
	protected JavaRefComposerModificationPage1_ModificationPage(
			final String id, final String label, final String title,
			final String description, final boolean isPageComplete,
			final int hspan) {
		super(id, label, title, description, isPageComplete, hspan);
	}

	/**
	 * @generated
	 */
	public JavaRefComposerModificationPage1_ModificationPage(final Item item) {
		super("modification-page1", "Java Content Composer",
				"Java Content Composer", "", false, 3);
		this.item = item;
		this.__short_name__ = createInternalNameField();
		this.fieldHasClasses = createFieldHasClasses();
		this.fieldFolderClasses = createFieldFolderClasses();
		this.fieldHasSources = createFieldHasSources();
		this.fieldFolderSources = createFieldFolderSources();
		setActionPage(null);
		addLast(this.__short_name__, this.fieldHasClasses,
				this.fieldFolderClasses, this.fieldHasSources,
				this.fieldFolderSources);

		registerListener();
	}

	@Override
	protected void registerListener() {
		// add init and register
		new PagepertyListener(fieldHasClasses, fieldHasSources,
				fieldFolderClasses, fieldFolderSources);
	}

	/**
	 * @generated
	 */
	public DCheckBoxUI createFieldHasClasses() {
		StringToBooleanModelControler mc = new StringToBooleanModelControler();
		return new DCheckBoxUI(
				CopyComposerCST.JAVA_REF_COMPOSER_at_HAS_CLASSES,
				"copy classes", EPosLabel.none, mc, null);
	}

	/**
	 * @generated
	 */
	public DCheckBoxUI createFieldHasSources() {
		StringToBooleanModelControler mc = new StringToBooleanModelControler();
		return new DCheckBoxUI(
				CopyComposerCST.JAVA_REF_COMPOSER_at_HAS_SOURCES,
				"copy sources", EPosLabel.none, mc, null);
	}

	/**
	 * @generated
	 */
	public DTextUI createFieldFolderSources() {
		return new DTextUI(CopyComposerCST.JAVA_REF_COMPOSER_at_FOLDER_SOURCES,
				"sources directory", EPosLabel.left, new MC_AttributesItem(),
				null, 1, "empty for default", false, false, false);
	}

	/**
	 * @generated
	 */
	public DTextUI createFieldFolderClasses() {
		return new DTextUI(CopyComposerCST.JAVA_REF_COMPOSER_at_FOLDER_CLASSES,
				"classes directory", EPosLabel.left, new MC_AttributesItem(),
				null, 1, "empty for default", false, false, false);
	}

}
