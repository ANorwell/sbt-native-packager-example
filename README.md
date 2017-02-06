This repo gives a reproduction of [this sbt-native-packager issue.](https://github.com/sbt/sbt-native-packager/issues/937#issuecomment-277450314)

To reproduce:

1. `sbt 'debian:packageBin'`
2. Try to install the resulting deb. It should fail with the errors:

```
Preparing to unpack sbt-native-packager-example_0.0.1_all.deb ...
/var/lib/dpkg/info/sbt-native-packager-example.prerm: 80: /var/lib/dpkg/info/sbt-native-packager-example.prerm: [Unit]: not found
dpkg: warning: subprocess old pre-removal script returned error exit status 127
dpkg: trying script from the new package instead ...
/var/lib/dpkg/tmp.ci/prerm: 80: /var/lib/dpkg/tmp.ci/prerm: [Unit]: not found
dpkg: error processing archive sbt-native-packager-example_0.0.1_all.deb (--install):
 subprocess new pre-removal script returned error exit status 127
/var/lib/dpkg/info/sbt-native-packager-example.postinst: 87: /var/lib/dpkg/info/sbt-native-packager-example.postinst: [Unit]: not found
```

Inspection of the deb (`dpkg -x` and `dpkg-deb -e`) show that the contents of `templates/systemloader/systemd` have been used both for the systemd unit file (expected behaviour by me) as well as in various deb hooks (not expected). Because the `systemd` template is a systemd unit file, it is not valid bash systax.

This may also be tested with the proposed fix in [this pr](https://github.com/sbt/sbt-native-packager/pull/938). To do so edit plugins.sbt by commenting out the 1.2.0-M8 version of sbt-native packager, and uncommenting the lines to use the modified version.
