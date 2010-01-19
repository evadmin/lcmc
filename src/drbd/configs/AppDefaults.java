/*
 * This file is part of DRBD Management Console by LINBIT HA-Solutions GmbH
 * written by Rasto Levrinc.
 *
 * Copyright (C) 2009, LINBIT HA-Solutions GmbH.
 *
 * DRBD Management Console is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published
 * by the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * DRBD Management Console is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with drbd; see the file COPYING.  If not, write to
 * the Free Software Foundation, 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package drbd.configs;

import java.awt.Color;
import java.util.Arrays;

/**
 * Here are default values for application.
 */
public class AppDefaults extends
            java.util.ListResourceBundle {
    /** Linbit orange. */
    private static final Color LINBIT_ORANGE       = new Color(250, 133, 34);
    /** Linbit light orange. */
    private static final Color LINBIT_LIGHT_ORANGE = new Color(253, 180, 109);

    /** Get contents. */
    protected final Object[][] getContents() {
        return Arrays.copyOf(contents, contents.length);
    }

    /** Contents. */
    private static Object[][] contents = {
        /*
         * defaults for development
         */
        {"DownloadLogin.User",      ""},
        {"DownloadLogin.Password",  ""},
        {"SSH.Host",                ""},
        {"SSH.SecHost",             ""},
        {"SSH.PublicKey",           ""},

        /*
         * error and warning messages handling.
         */
        /* show application errors in a dialog and stderr */
        {"AppError",         "n"},
        {"AppWarning",       "y"}, /* shows application warnings in stderr */
        {"DebugLevel",       0}, /* level -1 - no messages, 2 all messages */

        /*
         * locale
         */
        {"Locale.Lang",         "en"},
        {"Locale.Country",      "US"},
        /*
        {"Locale.Lang",         "de"},
        {"Locale.Country",      "DE"},
        */

        /*
         * dimensions of gui
         */
        {"DrbdMC.width",                        1120},
        {"DrbdMC.height",                       800},

        {"MainPanel.TerminalPanelDivider",       600},

        {"ConfigDialog.width",                   880},
        {"ConfigDialog.height",                  400},

        {"ConfirmDialog.width",                  400},
        {"ConfirmDialog.height",                 200},

        {"ExecCommandDialog.width",              600},
        {"ExecCommandDialog.height",             300},

        {"DialogButton.Width",                   40}, //!!!!! doesn't work
        {"DialogButton.Height",                  20},

        //{"ClusterBrowser.FieldWidth",            180}, // ??
        {"ClusterBrowser.ServiceLabelWidth",     150},
        {"ClusterBrowser.ServiceFieldWidth",     150},

        {"ClusterBrowser.DrbdResLabelWidth",     150},
        {"ClusterBrowser.DrbdResFieldWidth",     150},
        //{"GuiComboBox.width",                    200},
        //{"GuiComboBox.height",                   30},
        {"HostBrowser.DrbdDevLabelWidth",        150},
        {"HostBrowser.DrbdDevFieldWidth",        150},

        {"HostBrowser.ResourceInfoArea.Width",   300},
        {"HostBrowser.ResourceInfoArea.Height",  150},
        {"Browser.InfoPanelMinimalWidth",        440},
        {"Browser.FieldHeight",                  30},

        {"Dialog.DrbdConfigResource.LabelWidth", 150},
        {"Dialog.DrbdConfigResource.FieldWidth", 150},

        {"Dialog.DrbdConfigBlockDev.LabelWidth", 150},
        {"Dialog.DrbdConfigBlockDev.FieldWidth", 150},

        {"MainMenu.DrbdGuiFiles.Extension",     "drbdg"},
        {"MainMenu.DrbdGuiFiles.Default",       System.getProperty("user.home")
                                                + "/"
                                                + "drbd-gui.drbdg"},

        /*
         * Colors
         */
        //{"ViewPanel.Background",             new Color(240, 240, 240) },
        {"DefaultButton.Background",         LINBIT_ORANGE },
        {"ViewPanel.Background",             LINBIT_LIGHT_ORANGE },
        {"ViewPanel.Status.Background",      LINBIT_ORANGE },
        {"ViewPanel.Foreground",             Color.BLACK },
        {"ViewPanel.Status.Foreground",      Color.WHITE },
        {"EmptyViewPanel.Help.Background",   Color.WHITE },
        //{"ClustersPanel.Background",         LINBIT_LIGHT_ORANGE },
        {"ClustersPanel.Background",         Color.WHITE },
        {"HostsTab.Background",              Color.GRAY },
        {"TerminalPanel.Background",         Color.BLACK },
        {"TerminalPanel.Command", new Color(255, 187, 86) }, /* orange */
        {"TerminalPanel.Output",             Color.WHITE },
        {"TerminalPanel.Error",              Color.RED },
        {"TerminalPanel.Prompt",             Color.GREEN },

        {"TerminalPanel.TerminalBlack",      Color.BLACK},
        {"TerminalPanel.TerminalWhite",      Color.WHITE},
        {"TerminalPanel.TerminalDarkGray",   Color.GRAY},
        {"TerminalPanel.TerminalRed",        Color.RED},
        {"TerminalPanel.TerminalGreen",      Color.GREEN},
        {"TerminalPanel.TerminalYellow",     Color.YELLOW},
        {"TerminalPanel.TerminalBlue",       Color.BLUE},
        {"TerminalPanel.TerminalPurple",     new Color(128, 0, 128)},
        {"TerminalPanel.TerminalCyan",       Color.CYAN},

        {"ConfigDialog.Background",          Color.WHITE },
        {"ConfigDialog.Background.Dark",     LINBIT_LIGHT_ORANGE },
        {"ConfigDialog.Background.Light",    LINBIT_LIGHT_ORANGE },
        {"ConfigDialog.AnswerPane",          LINBIT_LIGHT_ORANGE },
        {"ConfigDialog.AnswerPane.Error",    Color.RED },
        {"ProgressBar.Background",           Color.WHITE },
        {"ProgressBar.Foreground",           LINBIT_ORANGE },

        {"ProgressBar.DefaultWidth",         300},
        {"ProgressBar.DefaultHeight",        30},

        {"ClusterTab.Background",            LINBIT_ORANGE },

        {"ResourceGraph.Background",         Color.WHITE },
        {"ResourceGraph.DrawPaint",          Color.BLACK },
        {"ResourceGraph.FillPaint",          Color.GREEN },
        {"ResourceGraph.FillPaintPicked",    Color.WHITE },
        {"ResourceGraph.PickedPaint",        Color.RED },

        {"ResourceGraph.EdgeDrawPaint", new Color(1, 1, 1) }, /* almost black */
        {"ResourceGraph.EdgeDrawPaintBrighter",   new Color(128, 128, 128) },
        {"ResourceGraph.EdgePickedPaint",         new Color(64, 64, 128) },
        {"ResourceGraph.EdgePickedPaintBrighter", new Color(160, 160, 255) },
        {"ResourceGraph.EdgeDrawPaintRemoved",    new Color(128, 64, 64) },
        {"ResourceGraph.EdgePickedPaintRemoved",  new Color(255, 64, 64) },

        {"HeartbeatGraph.FillPaintRemoved",       Color.LIGHT_GRAY },
        {"HeartbeatGraph.FillPaintFailed",        Color.RED },
        {"HeartbeatGraph.FillPaintUnconfigured",  Color.WHITE},
        {"HeartbeatGraph.FillPaintUnknown",       Color.LIGHT_GRAY},
        {"HeartbeatGraph.FillPaintStopped",       new Color(238, 238, 238)},

        {"DrbdGraph.FillPaintNotAvailable",       new Color(238, 238, 238) },
        {"DrbdGraph.FillPaintPrimary",            Color.GREEN },
        {"DrbdGraph.FillPaintSecondary",          Color.YELLOW },
        {"DrbdGraph.FillPaintUnknown",            Color.LIGHT_GRAY },

        {"DrbdGraph.EdgeDrawPaintDisconnected",   new Color(255, 50, 50) },
        {"DrbdGraph.EdgeDrawPaintDisconnectedBrighter",
                                                    new Color(200, 40, 40) },

        {"DrbdGraph.DrawPaintNotAvailable",       new Color(153, 153, 153) },
        {"Host.DefaultColor",                     Color.GREEN },
        {"Host.ErrorColor",                       Color.RED },
        {"Host.NoStatusColor",                    Color.LIGHT_GRAY },

        {"GuiComboBox.DefaultValue",              new Color(50, 50, 50) },
        {"GuiComboBox.SavedValue",                new Color(0, 120, 0) },
        {"GuiComboBox.ChangedValue",              Color.RED},
        {"GuiComboBox.ErrorValue",                new Color(255, 100, 100) },

        {"ClusterBrowser.Background",             new Color(255, 255, 255) },
        {"ClusterBrowser.Test.Tooltip.Background",Color.YELLOW},
        {"Browser.Background",                    new Color(255, 255, 255) },

        {"EmptyBrowser.StartPanelTitleBorder",    Color.BLACK },

        /*
         * Images
         */
        {"ConfigDialog.Icon",                     "teaser_drdb_boxes_01.png"},
        {"ClusterViewPanel.Logo",                 "logo_test.png"},

        {"Dialog.ClusterHosts.HostCheckedIcon",  "Icons/Checked.gif"},
        {"Dialog.ClusterHosts.HostUncheckedIcon", "Icons/Unchecked.gif"},
        {"Dialog.ClusterHbConfig.DopdCheckedIcon",  "Icons/Checked.gif"},
        {"Dialog.ClusterHbConfig.DopdUncheckedIcon", "Icons/Unchecked.gif"},
        {"Dialog.ClusterAisConfig.DefaultMCastAddress", "226.94.1.1"},
        {"Dialog.ClusterAisConfig.DefaultMCastPort",    "5405"},
        {"Browser.ResourceIcon", "Icons/16X16/crab.png"},
        {"Browser.CategoryIcon", "Icons/tango/16x16/folder_16x16.png"},
        {"Browser.ApplyIcon",    "Icons/tango/16x16/ok_16x16.png"},
        {"Browser.ActionsIcon",  "Icons/32X32/Arrow-down.png"},

        {"HostBrowser.BlockDeviceIcon",
                                    "Icons/tango/16x16/blockdevice_16x16.png"},

        {"HostBrowser.NetIntIcon", "Icons/tango/16x16/netzwk_16x16.png"},
        {"HostBrowser.FileSystemIcon", "Icons/tango/16x16/filesys_16x16.png"},
        {"HostBrowser.RemoveIcon", "Icons/tango/32x32/cancel_32x32.png"},
        {"ClusterBrowser.CommonBlockDeviceIcon",
                                    "Icons/tango/16x16/blockdevice_16x16.png"},

        {"ClusterBrowser.HostIcon", "Icons/tango/16x16/host_16x16.png"},
        {"HeartbeatGraph.ServiceRunningIcon",
                                "Icons/tango/32x32/service_active_32x32.png"},
        {"HeartbeatGraph.ServiceMigratedIcon",
                                "Icons/tango/32x32/service_migrated_32x32.png"},
        {"HeartbeatGraph.HostStandbyIcon",
                                "Icons/tango/32x32/host_standby_32x32.png"},
        {"HeartbeatGraph.HostStandbyOffIcon",
                                "Icons/tango/32x32/host_standbyoff_32x32.png"},
        {"HeartbeatGraph.ServiceUnmanagedIcon",
                               "Icons/tango/32x32/service_unmanaged_32x32.png"},

        {"HeartbeatGraph.ServiceNotRunningIcon",
                                        "Icons/tango/32x32/service_32x32.png"},
        {"ClusterBrowser.ServiceStartedIcon",
                                "Icons/tango/16x16/service_active_16x16.png"},
        {"ClusterBrowser.ServiceStoppedIcon",
                                       "Icons/tango/16x16/service_16x16.png"},
        {"ClusterBrowser.ServiceIcon", "Icons/tango/16x16/service1_16x16.png"},
        {"ClusterBrowser.NetworkIcon", "Icons/tango/16x16/netzwk_16x16.png"},
        {"ClusterBrowser.RemoveIcon",  "Icons/tango/32x32/cancel_32x32.png"},
        {"HostViewPanel.HostIcon",     "Icons/tango/32x32/host_32x32.png"},
        {"HostTab.HostIcon",           "Icons/tango/32x32/host_32x32.png"},
        {"HostBrowser.HostIcon",        "Icons/tango/32x32/host_32x32.png"},
        {"EmptyBrowser.HostIcon",        "Icons/tango/32x32/host_32x32.png"},

        {"MainMenu.ClusterIcon",       "Icons/tango/16x16/cluster_16x16.png"},
        {"MainMenu.HostIcon",          "Icons/tango/16x16/host_16x16.png"},

        {"MainPanel.ClustersIcon",     "Icons/tango/16x16/cluster_16x16.png"},
        {"MainPanel.HostsIcon",        "Icons/tango/16x16/host_16x16.png"},

        {"ClustersPanel.ClusterIcon",    "Icons/tango/32x32/cluster_32x32.png"},
        {"ClusterViewPanel.ClusterIcon", "Icons/tango/32x32/cluster_32x32.png"},
        {"HostsPanel.HostIcon",          "Icons/tango/32x32/host_32x32.png"},

        {"DrbdGraph.HarddiscIcon",
         "Icons/tango/32x32/blockdevice_32x32.png"},

        {"DrbdGraph.NoHarddiscIcon",    "Icons/tango/32x32/noharddisc.png"},
        {"DrbdGraph.HostIcon",          "Icons/tango/32x32/host_32x32.png"},

        {"HeartbeatGraph.ServiceIcon",  "Icons/tango/32x32/service1_32x32.png"},
        {"HeartbeatGraph.StartIcon",     "Icons/tango/32x32/ok_32x32.png"},
        //{"HeartbeatGraph.StopIcon",     "Icons/tango/32x32/cancel_32x32.png"},
        {"HeartbeatGraph.MigrateIcon",
                                "Icons/tango/32x32/service_migrated_32x32.png"},
        {"HeartbeatGraph.UnmigrateIcon",
                              "Icons/tango/32x32/service_unmigrate_32x32.png"},

        {"ClusterViewPanel.HostIcon",    "Icons/tango/32x32/host_32x32.png"},
        {"ClusterTab.ClusterIcon",      "Icons/tango/32x32/cluster_32x32.png"},

        {"ProgressIndicatorPanel.CancelIcon",
                                        "Icons/tango/32x32/cancel_32x32.png"},
        {"ProgressIndicatorPanel.InitIcon1",  "Icons/32X32/starfish.png"},
        {"ProgressIndicatorPanel.InitIcon2",  "Icons/32X32/shark.png"},
        {"ProgressIndicatorPanel.InitIcon3",  "Icons/32X32/crab.png"},
        {"ProgressIndicatorPanel.InitIcon4",  "Icons/32X32/server.png"},
        {"ProgressBar.CancelIcon", "Icons/tango/16x16/cancel_16x16.png"},

        {"Dialog.Dialog.BackIcon",     "Icons/tango/16x16/back2_16x16.png"},
        {"Dialog.Dialog.NextIcon",     "Icons/tango/16x16/next2_16x16.png"},
        {"Dialog.Dialog.CancelIcon",   "Icons/tango/16x16/cancel_16x16.png"},
        {"Dialog.Dialog.FinishIcon",   "Icons/tango/16x16/finish2_16x16.png"},

        {"Dialog.HostCheckInstallation.CheckingIcon",
         "Icons/32X32/dialog-information.png"},

        {"Dialog.HostCheckInstallation.NotInstalledIcon",
         "Icons/32X32/software-update-urgent.png"},

        {"Dialog.HostCheckInstallation.InstalledIcon",
         "Icons/32X32/weather-clear.png"},

        {"Dialog.HostCheckInstallation.UpgrAvailIcon",
         "Icons/32X32/software-update-available.png"},

        {"Dialog.HostFinish.HostIcon",
         "Icons/tango/32x32/host_32x32.png"},

        {"Dialog.HostFinish.ClusterIcon",
         "Icons/tango/32x32/cluster_32x32.png"},

        /*
         * ssh
         */
        //{"SSH.User",                          "rasto,root"},
        {"SSH.User",           "root"},
        {"SSH.ConnectTimeout", 30000}, /* milliseconds, 0 no timeout */
        {"SSH.KexTimeout",     30000}, /* milliseconds, 0 no timeout */
        {"SSH.Command.Timeout", 0},     /* milliseconds, 0 no timeout */
        {"ProgressBar.Sleep",  100},   /* milliseconds */
        {"ProgressBar.Delay",  50},    /* milliseconds */

        /*
          score
         */
        {"Score.Infinity",                    100000},
        {"Score.MinusInfinity",               -100000},

        /*
         * drbd
         */
       {"HostBrowser.DrbdNetInterfacePort",  7788},

        /*
         * other
         */
        {"MaxHops",                           20},

    };
}
