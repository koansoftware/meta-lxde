SUMMARY = "LXDE Panel"
HOMEPAGE = "http://lxde.org/"
SECTION = "x11"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=9d19a9495cc76dc96b703fb4aa157183"

DEPENDS = "gtk+ intltool-native menu-cache lxmenu-data libxmu libxpm alsa-lib libwnck wireless-tools pcmanfm libxml2 keybinder"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/lxpanel-${PV}.tar.xz \
           file://lxpanel-broken-apps.patch \
"
SRC_URI[md5sum] = "8d7c93c4ebb4af8bf436ef6d3aee4ea9"
SRC_URI[sha256sum] = "516ac4c83494ee99b2a0d2466458519a9a2668272eeff6d2162af3683b634104"

inherit autotools gettext pkgconfig

EXTRA_OECONF += "--enable-alsa --with-x --with-plugins=all"

FILES_${PN}-dbg += "${libdir}/lxpanel/plugins/.debug"
FILES_${PN}-dev += "${libdir}/lxpanel/*.so"
