package pro.gravit.launchermodules.myhttp;

import pro.gravit.launcher.base.modules.LauncherInitContext;
import pro.gravit.launcher.base.modules.LauncherModule;
import pro.gravit.launcher.base.modules.LauncherModuleInfo;
import pro.gravit.launcher.base.modules.events.PreConfigPhase;
import pro.gravit.launchserver.LaunchServer;
import pro.gravit.launchserver.auth.core.AuthCoreProvider;
import pro.gravit.utils.Version;

public class MyHttpModule extends LauncherModule {

    public MyHttpModule() {
        super(new LauncherModuleInfo("MyHttp", Version.of(1,0,0,0, Version.Type.DEV), new String[]{"LaunchServerCore"}));
    }

    @Override
    public void init(LauncherInitContext initContext) {
        registerEvent(this::preConfig, PreConfigPhase.class);
    }

    private void init(LaunchServer launchServer) {

    }

    public void preConfig(PreConfigPhase preConfigPhase) {
        AuthCoreProvider.providers.register("myhttp", MyHttpAuthCoreProvider.class);
    }
}
