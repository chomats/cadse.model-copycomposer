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

import fede.workspace.eclipse.composition.copy.composer.JavaCopyComposer;

import fede.workspace.model.manager.properties.FieldsCore;
import model.workspace.copycomposer.CopyComposerCST;
import model.workspace.copycomposer.managers.JavaRefComposerManager;
import fede.workspace.model.manager.properties.impl.mc.StringToBooleanModelControler;
import fede.workspace.model.manager.properties.impl.ui.DCheckBoxUI;
import fr.imag.adele.cadse.cadseg.pages.build.ComposerCreationPage1_CreationPage;
import fr.imag.adele.cadse.core.CadseException;
import fr.imag.adele.cadse.core.IItemNode;
import fr.imag.adele.cadse.core.Item;
import fr.imag.adele.cadse.core.ItemType;
import fr.imag.adele.cadse.core.Link;
import fr.imag.adele.cadse.core.LinkType;
import fr.imag.adele.cadse.core.impl.ui.PageImpl;
import fr.imag.adele.cadse.core.ui.EPosLabel;
import fr.imag.adele.cadse.core.ui.IActionPage;
import fr.imag.adele.cadse.core.ui.IPage;
import fr.imag.adele.cadse.core.ui.IPageController;
import fr.imag.adele.cadse.core.ui.PageFactory;
import fr.imag.adele.cadse.core.ui.UIField;

/**
 * @generated
 */
public class JavaRefComposerCreationPage1_CreationPage extends
		ComposerCreationPage1_CreationPage {

	/**
	 * @generated
	 */
	protected DCheckBoxUI fieldHasSources;

	/**
	 * @generated
	 */
	protected DCheckBoxUI fieldHasClasses;

	/**
	 * @generated
	 */
	protected JavaRefComposerCreationPage1_CreationPage(final String id,
			final String label, final String title, final String description,
			final boolean isPageComplete, final int hspan) {
		super(id, label, title, description, isPageComplete, hspan);
	}

	/**
	 * @generated
	 */
	public JavaRefComposerCreationPage1_CreationPage(final Item parent,
			final ItemType it, final LinkType lt) {
		super("creation-page1", "Create a new composer to copy Java content",
				"Create a new composer to copy Java content", "", false, 3);
		this.parent = parent;
		this.it = it;
		this.lt = lt;
		this.fieldHasClasses = createFieldHasClasses();
		this.fieldHasSources = createFieldHasSources();
		setActionPage(null);
		addLast(this.fieldHasClasses, this.fieldHasSources);

		registerListener();
	}

	@Override
	protected void registerListener() {
		// add init and register
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
	public DCheckBoxUI createFieldHasClasses() {
		StringToBooleanModelControler mc = new StringToBooleanModelControler();
		return new DCheckBoxUI(
				CopyComposerCST.JAVA_REF_COMPOSER_at_HAS_CLASSES,
				"copy classes", EPosLabel.none, mc, null);
	}

	@Override
	public void init(IPageController pageController) throws CadseException {
		super.init(pageController);
		JavaRefComposerManager.setFolderSourcesAttribute(getItem(),
				JavaCopyComposer.COMPONENTS_SOURCES);
		JavaRefComposerManager.setFolderClassesAttribute(getItem(),
				JavaCopyComposer.COMPONENTS_CLASSES);
	}

}
