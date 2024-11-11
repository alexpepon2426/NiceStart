## NiceStart

## Este **repositorio** ira mostrando los distintos avances que se vayan produciendo a lo largo del proyecto
>Estos son los avances de la pantalla de ***login***, en el se puede ver los botones de registro e inicio de sesión con una imagen de fondo y un fondo con un gradiente
![login activity](img/login.png)
>Estos son los avances de la pantalla de ***signup***, posee dos botones, uno para iniciar sesión que nos llevaria a la actividad principal y otro para cancelar que sería para volver a la actividad de inicio
![signup activity](img/signup.png)
>Estos son los avances de la pantalla de ***main***, esta actividad se encuentra aun en desarrollo
![main activity](img/main.png)
> Queda añadida la pantalla **Profile**
![profile_activity](img/profile.png)
>Se añade la pantalla Splash que es la que da inicio a la aplicacion
![activity_splash](img/splash.png)
> 
> Se añaden animaciones nuevas a la Activity del **Splash**
>Esta es la animación la Activity Splash
![activity_splash](videos/splash.gif) 
```    
Código Java

    public class Splash extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        openApp();
        ImageView thunder = findViewById(R.id.logosplash);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.rotate_ani);
        thunder.startAnimation(myanim);
        }
```
>Código de la animación de la rotación
```
Código del XML

<?xml version="1.0" encoding="utf-8"?>
<rotate xmlns:android="http://schemas.android.com/apk/res/android"
    android:duration="3000"
    android:fillAfter="true"
    android:fromDegrees="0"
    android:pivotX="50%"
    android:pivotY="50%"
    android:toDegrees="-90"
    />
```

>Se añaden a la Activity **Main** una appbar con una opcion para poder ir a la Activity de **Profile**
>![activity_main](img/mainV2.png)

>[!IMPORTANT]
>
>Este Readme se encuentra sujeto a cambios, Fecha 30/10/24.

>This repository is licensed under