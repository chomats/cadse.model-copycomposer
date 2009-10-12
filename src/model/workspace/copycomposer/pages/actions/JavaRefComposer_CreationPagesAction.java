package model.workspace.copycomposer.pages.actions;


import fr.imag.adele.cadse.core.Item;
import fr.imag.adele.cadse.core.ItemType;
import fr.imag.adele.cadse.core.LinkType;
import fr.imag.adele.cadse.core.impl.ui.CreationAction;



/**
    @generated
*/
public class JavaRefComposer_CreationPagesAction extends CreationAction {


	/**
	    @generated
	*/
	public JavaRefComposer_CreationPagesAction(Item parent, ItemType type, LinkType lt, final String defaultName) {
		super(parent, type, lt, defaultName);
	}

	/**
	    @generated
	*/
	public JavaRefComposer_CreationPagesAction(Item parent, ItemType type, LinkType lt) {
		super(parent, type, lt);
	}

	@Override
	protected String getFinishAutomaticShortName() {
	try {
		return "JavaContentComposer";
	} catch (Throwable e) {
		e.printStackTrace();
		return "error";
	}
	}


}

