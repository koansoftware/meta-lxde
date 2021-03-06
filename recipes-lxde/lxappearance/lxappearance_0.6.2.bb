SUMMARY = "LXDE GTK+ theme switcher"
HOMEPAGE = "http://lxde.org/"
SECTION = "x11"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "glib-2.0-native intltool-native"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${P}.tar.xz"
SRC_URI[md5sum] = "21ee79c7686a80efddaa1b7928f51e21"
SRC_URI[sha256sum] = "4462136e01f991d4c546f23a8cf59a4092f88ecdff587597959f8062e2ea201f"

PACKAGECONFIG ?= "gtk3"
PACKAGECONFIG[gtk3] = "--enable-gtk3,,gtk+3"
python __anonymous () {
    depends = d.getVar("DEPENDS", d, 1)
    if 'gtk3' not in d.getVar('PACKAGECONFIG', True):
        d.setVar("DEPENDS", "%s gtk+" % depends)
}

inherit autotools gettext pkgconfig

fakeroot do_fixup_ownership () {
    find ${WORKDIR}/package/usr/src -exec chown 0:0 {} \;
}

addtask do_fixup_ownership after do_package before do_packagedata
