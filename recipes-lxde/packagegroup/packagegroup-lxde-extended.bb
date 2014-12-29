DESCRIPTION = "All packages required for full LXDE installation."
SECTION = "x11/wm"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PR = "r0"

inherit packagegroup

RDEPENDS_${PN} = "\
    packagegroup-lxde-base \
"

RRECOMMENDS_${PN} = " \
    gpicview \
    lxtask \
    lxinput \
"
