# 📱 Application Formulaire Android


## 📋 Description
Application Android développée dans le cadre du **Lab 3** du cours "Programmation Mobile Android avec Java".  
L'application permet de saisir des informations personnelles via un formulaire et de les afficher sur un écran récapitulatif.

## 🎯 Objectifs pédagogiques
- Création d'interfaces avec **ScrollView** et **LinearLayout**
- Utilisation des composants UI (**EditText**, **TextView**, **Button**)
- Navigation entre activités avec **Intent explicite**
- Transfert de données avec **putExtra() / getStringExtra()**
- Gestion du cycle de vie (**finish()**, **onResume()**)

## 📸 Captures d'écran

### Étape 1: Création du projet
![Step 1](screenshots/step1_project_creation.png)

### Étape 2: Interface du formulaire (activity_main.xml)
![Step 2](screenshots/step2_form_layout.png)

### Étape 3: Interface du récapitulatif (activity_screen2.xml)
![Step 3](screenshots/step3_summary_layout.png)

### Étape 4: Code Java - Screen2Activity
![Step 4](screenshots/step4_screen2_java.png)

### Étape 5: Code Java - MainActivity
![Step 5](screenshots/step5_main_java.png)

### Étape 6: AndroidManifest.xml
![Step 6](screenshots/step6_manifest.png)

### Étape 7: Application en cours d'exécution
![Step 7 - Formulaire](screenshots/step7_app_form.png)
![Step 7 - Formulaire](screenshots/step7_app_form2.png)
![Step 7 - Récapitulatif](screenshots/step7_app_summary.png)


## 🏗️ Structure du projet
app/
├── manifests/
│ └── AndroidManifest.xml
├── java/
│ └── com.example.formulaire/
│ ├── MainActivity.java
│ └── Screen2Activity.java
└── res/
└── layout/
├── activity_main.xml
└── activity_screen2.xml
