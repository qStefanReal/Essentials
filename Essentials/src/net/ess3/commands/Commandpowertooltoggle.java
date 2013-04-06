package net.ess3.commands;

import static net.ess3.I18n._;
import net.ess3.api.IUser;
import net.ess3.user.UserData;


public class Commandpowertooltoggle extends EssentialsCommand
{
	@Override
	protected void run(final IUser user, final String commandLabel, final String[] args) throws Exception
	{
		final UserData userData = user.getData();
		if (!userData.hasPowerTools())
		{
			user.sendMessage(_("You have no power tools assigned."));
			return;
		}
		userData.setPowerToolsEnabled(!userData.isPowerToolsEnabled());
		user.queueSave();
		user.sendMessage(
				userData.isPowerToolsEnabled() ? _("All of your power tools have been enabled.") : _("All of your power tools have been disabled."));
	}
}
