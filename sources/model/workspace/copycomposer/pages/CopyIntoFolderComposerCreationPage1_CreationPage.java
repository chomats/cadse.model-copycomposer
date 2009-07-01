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
import fede.workspace.model.manager.properties.IInteractionControllerForList;
import model.workspace.copycomposer.CopyComposerCST;
import fede.workspace.model.manager.properties.impl.ic.IC_LinkForBrowser_Combo_List;
import fede.workspace.model.manager.properties.impl.ic.IC_DefaultForList;
import fede.workspace.model.manager.properties.impl.mc.LinkModelController;
import fede.workspace.model.manager.properties.impl.mc.MC_DefaultForList;
import fede.workspace.model.manager.properties.impl.mc.StringToBooleanModelControler;
import fede.workspace.model.manager.properties.impl.ui.DCheckBoxUI;
import fede.workspace.model.manager.properties.impl.ui.DListUI;
import fede.workspace.model.manager.properties.impl.ui.DTextUI;
import fr.imag.adele.cadse.cadseg.IC_ItemTypeTemplateForText;
import fr.imag.adele.cadse.cadseg.WorkspaceCST;
import fr.imag.adele.cadse.cadseg.managers.build.CompositeItemTypeManager;
import fr.imag.adele.cadse.cadseg.pages.build.composer.EclipseComposerCreationPage1_CreationPage;
import fr.imag.adele.cadse.core.IItemNode;
import fr.imag.adele.cadse.core.Item;
import fr.imag.adele.cadse.core.ItemType;
import fr.imag.adele.cadse.core.Link;
import fr.imag.adele.cadse.core.LinkType;
import fr.imag.adele.cadse.core.impl.ui.MC_AttributesItem;
import fr.imag.adele.cadse.core.impl.ui.PageImpl;
import fr.imag.adele.cadse.core.ui.EPosLabel;
import fr.imag.adele.cadse.core.ui.IActionPage;
import fr.imag.adele.cadse.core.ui.IModelController;
import fr.imag.adele.cadse.core.ui.IPage;
import fr.imag.adele.cadse.core.ui.PageFactory;
import fr.imag.adele.cadse.core.ui.UIField;

/**
 * @generated
 */
public class CopyIntoFolderComposerCreationPage1_CreationPage extends
		EclipseComposerCreationPage1_CreationPage {

	/**
	 * @generated
	 */
	static public class TargetFolderMC extends MC_AttributesItem {

		/**
		 * @generated
		 */
		public TargetFolderMC() {
			super();
		}

		@Override
		public Object defaultValue() {
			return ""; // by default, we copy to root directory
		}

	}

	/**
	 * @generated
	 */
	protected DTextUI fieldTargetFolder;

	/**
	 * @generated
	 */
	protected DCheckBoxUI fieldExtendsClass;

	/**
	 * @generated
	 */
	protected DListUI fieldManagesLT;

	/**
	 * @generated
	 */
	protected CopyIntoFolderComposerCreationPage1_CreationPage(final String id,
			final String label, final String title, final String description,
			final boolean isPageComplete, final int hspan) {
		super(id, label, title, description, isPageComplete, hspan);
	}

	/**
	 * @generated
	 */
	public CopyIntoFolderComposerCreationPage1_CreationPage(final Item parent,
			final ItemType it, final LinkType lt) {
		super("creation-page1", "Create a new composer to copy folder content",
				"Create a new composer to copy folder content", "", false, 3);
		this.parent = parent;
		this.it = it;
		this.lt = lt;
		this.__short_name__ = createInternalNameField();
		this.fieldTargetFolder = createFieldTargetFolder();
		this.fieldManagesLT = createFieldManagesLT();
		this.fieldTypes = createFieldTypes();
		this.fieldExtendsClass = createFieldExtendsClass();
		setActionPage(null);
		addLast(this.__short_name__, this.fieldTargetFolder,
				this.fieldManagesLT, this.fieldTypes, this.fieldExtendsClass);

		registerListener();
	}

	@Override
	protected void registerListener() {
		super.registerListener();
		// add init and register
	}

	/**
	 * 
	 */
	public DTextUI createFieldTargetFolder() {
		final TargetFolderMC mc = new TargetFolderMC();
		return new DTextUI(
				CopyComposerCST.COPY_INTO_FOLDER_COMPOSER_at_TARGET_FOLDER,
				"Target Folder :", EPosLabel.left, mc,
				new IC_ItemTypeTemplateForText() {
					@Override
					protected Item getItemFromContext() {
						final Item compositeItemType = getContext()
								.getPartParent();
						final Item itemType = CompositeItemTypeManager
								.getItemType(compositeItemType);
						return itemType;
					}
				}, 0, 1, "");
	}

	/**
	 * @generated
	 */
	public DCheckBoxUI createFieldExtendsClass() {
		StringToBooleanModelControler mc = new StringToBooleanModelControler();
		return new DCheckBoxUI(WorkspaceCST.COMPOSER_at_EXTENDS_CLASS,
				"extend generated class", EPosLabel.none, mc, null);
	}

	/**
	 * @generated
	 */
	@Override
	public DListUI createFieldTypes() {
		MC_DefaultForList mc = new MC_DefaultForList(1, -1);
		IC_DefaultForList ic = new IC_DefaultForList("Add a type.",
				"The string represent a exported type.", false);
		return new DListUI(WorkspaceCST.COMPOSER_at_TYPES, "content types",
				EPosLabel.top, mc, ic, true, false, false, false);
	}

	/**
	 * @generated
	 */
	public DListUI createFieldManagesLT() {
		LinkModelController mc = new LinkModelController(true, null,
				CopyComposerCST.COPY_INTO_FOLDER_COMPOSER_lt_MANAGES_LT);
		IC_LinkForBrowser_Combo_List ic = new IC_LinkForBrowser_Combo_List(
				"Select a link type",
				"Select a link type which has kind composition",
				CopyComposerCST.COPY_INTO_FOLDER_COMPOSER_lt_MANAGES_LT);
		return new DListUI(
				CopyComposerCST.COPY_INTO_FOLDER_COMPOSER_lt_MANAGES_LT
						.getName(), "Links used to copy folder content",
				EPosLabel.top, mc, ic, true, false, false, false);
	}

}
