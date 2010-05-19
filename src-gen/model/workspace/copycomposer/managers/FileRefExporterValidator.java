/**
 * 
 */
package model.workspace.copycomposer.managers;

import java.util.List;

import model.workspace.copycomposer.CopyComposerCST;
import fr.imag.adele.cadse.cadseg.eclipse.ParseTemplate;
import fr.imag.adele.cadse.cadseg.exp.ParseException;
import fr.imag.adele.cadse.cadseg.managers.content.ManagerManager;
import fr.imag.adele.cadse.core.Item;
import fr.imag.adele.cadse.core.Validator;

public class FileRefExporterValidator implements Validator {
	
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
		return null;
	}

	@Override
	public Class<Validator> getClassAdapt() {
		return Validator.class;
	}
}