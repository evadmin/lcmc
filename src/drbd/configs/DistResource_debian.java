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

import java.util.Arrays;

/**
 * Here are commands for all debians.
 */
public class DistResource_debian extends
            java.util.ListResourceBundle {

    /** Get contents. */
    protected final Object[][] getContents() {
        return Arrays.copyOf(contents, contents.length);
    }

    /** Contents. */
    private static Object[][] contents = {
        {"Support",             "debian"},
        //{"distribution",        "debian"},
        {"version:3*",          "3"},
        {"version:5*",          "LENNY"},
        {"version:debian-etch", "ETCH"},
        {"version:4*",          "ETCH"},

        {"arch:x86_64",       "amd64"}, // convert arch to arch in the drbd download file

        /* directory capturing regexp on the website from the kernel version */
        {"kerneldir", "(\\d+\\.\\d+\\.\\d+-\\d+).*"},

        {"DrbdInst.install", "echo | dpkg -i --force-confold /tmp/drbdinst/@DRBDPACKAGE@ /tmp/drbdinst/@DRBDMODULEPACKAGE@"},

        {"HbPmInst.install.text.1", "the debian way: HB 2.1.x (obsolete)"},
        {"HbPmInst.install.1",
         "apt-get update && /usr/bin/apt-get -y -q install -o 'DPkg::Options::force=--force-confnew' heartbeat-2"},

        /* Drbd install method 2 */
        {"DrbdInst.install.text.2",
         "from the source tarball"},

        {"DrbdInst.install.method.2",
         "source"},

        {"DrbdInst.install.2",
         "/bin/mkdir -p /tmp/drbdinst && "
         + "/usr/bin/wget --directory-prefix=/tmp/drbdinst/"
         + " http://oss.linbit.com/drbd/@VERSIONSTRING@ && "
         + "cd /tmp/drbdinst && "
         + "/bin/tar xfzp drbd-@VERSION@.tar.gz && "
         + "cd drbd-@VERSION@ && "
         + "/usr/bin/apt-get update && "
         + "/usr/bin/apt-get -y install make flex linux-headers-`uname -r` && "
         + "make && make install && "
         //+ "/usr/sbin/update-rc.d drbd defaults 70 8 && "
         + "/bin/rm -rf /tmp/drbdinst"},

        /* Drbd install method 3 */
        {"DrbdInst.install.text.3",
         "the debian way: 8.0.x (obsolete)"},

        {"DrbdInst.install.3",
         "apt-get update && /usr/bin/apt-get -y install -o "
         + "'DPkg::Options::force=--force-confnew' drbd8-modules-`uname -r` drbd8-utils"},

        {"HbCheck.version",
         "/usr/local/bin/drbd-gui-helper get-cluster-versions;"
         + "/usr/bin/dpkg-query -f='${Status} ais:${Version}\n' -W openais 2>&1|grep '^install ok installed'|cut -d ' ' -f 4"
         + "|sed 's/-.*//'"},

//        {"Openais.reloadOpenais",
//         "/etc/init.d/openais force-reload"},

        {"Heartbeat.deleteFromRc",
         "/usr/sbin/update-rc.d heartbeat remove"},

        {"Heartbeat.addToRc",
         "/usr/sbin/update-rc.d heartbeat start 75 2 3 4 5 . stop 05 0 1 6 . "},

        {"Corosync.addToRc",
         "/usr/sbin/update-rc.d corosync start 75 2 3 4 5 . stop 05 0 1 6 . "},

        {"Corosync.deleteFromRc",
         "/usr/sbin/update-rc.d corosync remove"},

        {"Openais.addToRc",
         "/usr/sbin/update-rc.d openais start 75 2 3 4 5 . stop 05 0 1 6 . "},

        {"Openais.deleteFromRc",
         "/usr/sbin/update-rc.d openais remove"},

        /* openais/pacemaker from source */
        {"PmInst.install.text.2",
         "from source: latest/whitetank"},

        {"PmInst.install.2",
         "export PREFIX=/usr;"
         + "export LCRSODIR=$PREFIX/libexec/lcrso;"
         + "export CLUSTER_USER=hacluster;"
         + "export CLUSTER_GROUP=haclient;"
         + "apt-get update"
         + " && apt-get -y -q  --allow-unauthenticated install"
         + " -o 'DPkg::Options::force=--force-confnew'"
         + " bzip2 automake libtool make pkg-config libglib2.0-dev libxml2-dev"
         + " libbz2-dev uuid-dev libsnmp-dev subversion libxslt1-dev psmisc"
         + " libltdl3-dev"
         + " && /bin/mkdir -p /tmp/pminst "
         /* cluster glue */
         + " && /usr/bin/wget -O /tmp/pminst/cluster-glue.tar.bz2"
         + " http://hg.linux-ha.org/glue/archive/tip.tar.bz2"
         + " && cd /tmp/pminst"
         + " && /bin/tar xfjp cluster-glue.tar.bz2"
         + " && cd Reusable-Cluster-Components-*"
         + " && ./autogen.sh && ./configure --prefix=$PREFIX"
         + " --with-daemon-user=${CLUSTER_USER}"
         + " --with-daemon-group=${CLUSTER_GROUP}"
         + " && make && make install"
         /* resource agents */
         + " && /usr/bin/wget -O /tmp/pminst/resource-agents.tar.bz2"
         + " http://hg.linux-ha.org/agents/archive/tip.tar.bz2"
         + " && cd /tmp/pminst"
         + " && /bin/tar xfjp resource-agents.tar.bz2"
         + " && cd Cluster-Resource-Agents-*"
         + " && ./autogen.sh && ./configure --prefix=$PREFIX"
         + " && make && make install"
         /* openais */
         + " && cd /tmp/pminst"
         + " && svn co"
         + " http://svn.fedorahosted.org/svn/openais/branches/whitetank"
         + " && cd /tmp/pminst/whitetank/"
         + " && make PREFIX=$PREFIX LCRSODIR=$LCRSODIR"
         + " && make install PREFIX=$PREFIX LCRSODIR=$LCRSODIR STATICLIBS=NO"
         + " && cp init/generic /etc/init.d/openais"
         + " && chmod a+x /etc/init.d/openais"
         + " && (addgroup --system --group ais;"
         + " adduser --system --no-create-home --ingroup ais"
         + " --disabled-login --shel /bin/false --disabled-password ais;"
         + " addgroup --system --group haclient;"
         + " adduser --system --no-create-home --ingroup haclient"
         + " --disabled-login --shel /bin/false --disabled-password hacluster;"
         + " true)"
         /* pacemaker */
         + " && /usr/bin/wget -O /tmp/pminst/pacemaker.tar.bz2"
         + " http://hg.clusterlabs.org/pacemaker/stable-1.0/archive/tip.tar.bz2"
         + " && cd /tmp/pminst"
         + " && /bin/tar xfjp pacemaker.tar.bz2"
         + " && cd Pacemaker-1-*"
         + " && ./autogen.sh"
         + " && ./configure --prefix=$PREFIX --with-lcrso-dir=$LCRSODIR"
         + " --disable-fatal-warnings"
         + " && make && make install"
         + " && if [ -e /etc/ais/openais.conf ];then"
         + " mv /etc/ais/openais.conf /etc/ais/openais.conf.orig; fi"
         + " && if [ -e /etc/corosync/corosync.conf ]; then"
         + " mv /etc/corosync/corosync.conf /etc/corosync/corosync.conf.orig; fi"},

        /* heartbeat/pacemaker madkiss */
        {"HbPmInst.install.text.1",
         "LINBIT/MADKISS repo: 1.0.x/3.0.x (not working yet)"},

        {"HbPmInst.install.1",
         "echo 'deb http://people.debian.org/~madkiss/ha-corosync lenny main' > /etc/apt/sources.list.d/ha-clustering.list "
         + " && apt-get update"
         + " && apt-get -y -q  --allow-unauthenticated install"
         + " -o 'DPkg::Options::force=--force-confnew' pacemaker-heartbeat"},
         //+ " && chmod g+w /var/run/heartbeat/crm" // TODO: remove workarounds
         //                                         // when not needed
         //+ " && ln -s /var/run/heartbeat/crm/ /var/run/crm"},

        /* heartbeat apt-get install */
        {"HbPmInst.install.text.2",
         "the debian way: HB 2.1.3 (obsolete)"},

        {"HbPmInst.install.2",
         "apt-get update && "
         + "/usr/bin/apt-get -y -q install -o"
         + " 'DPkg::Options::force=--force-confnew' heartbeat-2"},
    };
}
