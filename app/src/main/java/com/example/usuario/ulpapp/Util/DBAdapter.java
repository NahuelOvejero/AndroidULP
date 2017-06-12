package com.example.usuario.ulpapp.Util;

/**
 * Created by Usuario on 18/05/2017.
 */


import android.database.Cursor;

import  android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.usuario.ulpapp.Database.model.Autoridades;
import com.example.usuario.ulpapp.Database.model.Lugar;
import com.example.usuario.ulpapp.Database.model.Residencia;
import com.example.usuario.ulpapp.parser.Noticia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBAdapter {

    private DBHelper dbHelper;
    private SQLiteDatabase sqlDB;

    private final static int DB_VERSION = 1;
    private final static String DB_NAME = "ULP";

    private CarreraAdapter carreraAdapter;
    private CarreraxMateriaAdapter carreraxMateriaAdapter;
    private ComodidadAdapter comodidadAdapter;
    private Competente_enAdapter competente_enAdapter;
    private DocumentacionAdapter documentacionAdapter;
    private FotoAdapter fotoAdapter;
    private RequisitoxCarreraAdapter requisitoxCarreraAdapter;
    private LugarAdapter lugarAdapter;
    private MateriaAdapter materiaAdapter;
    private ObjetivoAdapter objetivoAdapter;
    private Profesional_queAdapter profesional_queAdapter;
    private RequisitoAdapter requisitoAdapter;
    private  ResidenciaAdapter residenciaAdapter;
    private PorQueEstudiarAdapter porQueEstudiarAdapter;
    private NoticiaAdapter noticiaAdapter;
    private AcercaULPAdapter acercaULPAdapter;
    private AutoridadesULPAdapter autoridadesULPAdapter;
    private MisionULPAdapter misionULPAdapter;
    private VisionULPAdapter visionULPAdapter;
    private ValoresULPAdapter valoresULPAdapter;

    // DEFINIR LOS ADAPTERS DE CADA TABLA


    public DBAdapter(Context con) {
        dbHelper = new DBHelper(con);
    }



    public boolean insertCarrera(int idcarrera,String nombre,float duracion,int idLugar,String desc){
       return carreraAdapter.insert(idcarrera,nombre,duracion,idLugar,desc);
    }

    public boolean insertComodidad(int idComodidad, String desc, int residencia){
        return comodidadAdapter.insert(idComodidad,desc,residencia);
    }

    public boolean insertDocumentacion(int id, String desc,int idResidencia){
        return documentacionAdapter.insert(id,desc,idResidencia);
    }

    public boolean insertFoto(String url, int idcarrera){
        return fotoAdapter.insert(url,idcarrera);
    }
    public boolean insertLugar(int IdLugar,String dir, String tel, double latitud,double longitud){
        return lugarAdapter.insert(IdLugar,dir,tel,latitud,longitud);
    }

    public boolean insertMateria(int id,String nombre,int año){
        return materiaAdapter.insert(id,nombre,año);
    }

    public boolean insertObjetivo (int id, String des, int res){
        return objetivoAdapter.insert(id,des,res);
    }

    /*
    public boolean booleaninsertPerfil(){

    }*/
    public Cursor joinCarreraLugar(int IdCarrera){
        String TC=CarreraAdapter.getName();
        String TL=LugarAdapter.getName();
        String query= "Select Telefono,Latitud,Longitud,Direccion,Titulo,Duracion from "+TC+" inner join "+ TL+" on "+TL+"."+ LugarAdapter.getColumnId()+"="+TC+".Id_lugar_cursado where "+CarreraAdapter.getColumnId()+"=?";
        return sqlDB.rawQuery(query,new String[]{String.valueOf(IdCarrera)});}
    public boolean insertCarreraxMateria(int id,int carreraID){
        return carreraxMateriaAdapter.insert(id,carreraID);
    }



    public boolean insertResidencia(int id, String desc, String pago, String contact,String titulo, String urlficha,String urldeclaracion){

        return residenciaAdapter.insert(id,desc,pago,contact,titulo,urlficha,urldeclaracion);

    }
    public boolean insertarNoticias(List<Noticia> lista){

        int id=1;
        for(Noticia it:lista){

            noticiaAdapter.insert(id,it.getTitulo(),it.getDescripcion(),it.getFecha(),it.getFoto());
            id++;
        }
        if(lista.size()>0){return true;}
        else{return false;}
    }

    public void vaciarTablaNoticia(){
        noticiaAdapter.vaciarTabla();
    }
    public int ultimaActualizacionNoticias(){
        if(!noticiaAdapter.isEmpty() &&noticiaAdapter.noticia(1)!=null){
            Log.d("Fechas","Fechass");
            String fecha=null;
            Cursor c=noticiaAdapter.noticia(1);
            if(c.moveToFirst()){

                do{
                    //VERIFICAR INDICE DEL NOMBRE DE LA CARRERA EN LA TABLA
                    fecha=c.getString(0);
                }while(c.moveToNext());

            }


                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaDate = null;
                try {
                    fechaDate = formato.parse(fecha);
                }
                catch (ParseException ex)
                {
                    System.out.println(ex);
                }
                return fechaDate.getMonth();
            } else {
            return 0;
            }
        }



    public void open() {

        sqlDB = dbHelper.getWritableDatabase();
        carreraAdapter=new CarreraAdapter(sqlDB);
        comodidadAdapter=new ComodidadAdapter(sqlDB);
        carreraxMateriaAdapter=new CarreraxMateriaAdapter(sqlDB);
        comodidadAdapter=new ComodidadAdapter(sqlDB);
        competente_enAdapter=new Competente_enAdapter(sqlDB);
        documentacionAdapter=new DocumentacionAdapter(sqlDB);
        fotoAdapter=new FotoAdapter(sqlDB);
        requisitoxCarreraAdapter =new RequisitoxCarreraAdapter(sqlDB);
        lugarAdapter=new LugarAdapter(sqlDB);
        materiaAdapter=new MateriaAdapter(sqlDB);
        objetivoAdapter=new ObjetivoAdapter(sqlDB);
        profesional_queAdapter=new Profesional_queAdapter(sqlDB);
        requisitoAdapter=new RequisitoAdapter(sqlDB);
        residenciaAdapter=new ResidenciaAdapter(sqlDB);
        porQueEstudiarAdapter=new PorQueEstudiarAdapter(sqlDB);
        noticiaAdapter=new NoticiaAdapter(sqlDB);
        acercaULPAdapter=new AcercaULPAdapter(sqlDB);
        autoridadesULPAdapter=new AutoridadesULPAdapter(sqlDB);
        misionULPAdapter=new MisionULPAdapter(sqlDB);
        visionULPAdapter=new VisionULPAdapter(sqlDB);
        valoresULPAdapter=new ValoresULPAdapter(sqlDB);
        generarBD();

    }
    public void generarBD(){
        if(lugarAdapter.isEmpty())
        {
            lugarAdapter.insert(1,"Av. Universitaria s/n, 5710 La Punta, San Luis","4452000",-33.1511496,-66.3058375);
            lugarAdapter.insert(2," Av. Lafinur 840, San Luis","4452000",-33.301986,-66.3470709);
        }
        if(carreraAdapter.isEmpty()){
            carreraAdapter.insert(1,"Tecnicatura en Gestión Empresarial",3,2,"Está diseñada en respuesta a la demanda del mercado que, ante un crecimiento económico y un aumento en la competitividad, necesita de profesionales que agilicen la gestión dentro de las empresas. El profesional contará con las herramientas para optimizar la utilización de los recursos de la empresa. También, podrá generar su propio emprendimiento.");
            carreraAdapter.insert(2,"Tecnicatura en Desarrollo de Software",3,1,"La carrera está diseñada para permitir una rápida inserción en el ámbito laboral. Los conocimientos adquiridos le permitirán al egresado insertarse en compañías de la industria tecnológica y de otras actividades de la economía, como así también, en el ámbito gubernamental.");
            carreraAdapter.insert(3,"Tecnicatura en Turismo",3,2,"Desde una perspectiva local, la provincia de San Luis ha definido a la actividad turística como una de las áreas centrales para su desarrollo, convirtiéndose en un destino turístico centrado en su riqueza cultural, histórica y natural. El profesional egresado reunirá aptitudinalmente las condiciones para administrar y conformar agencias de viajes y turismo, como así también formular proyectos inherentes");
            carreraAdapter.insert(4,"Tecnicatura en Guía de Turismo",3,2,"San Luis se ha convertido en uno de los principales destinos turísticos del país, gracias a las políticas aplicadas por el Gobierno provincial. En esta tecnicatura se brinda una propuesta formativa que integre los aspectos básicos, aplicados, prácticos y éticos profesionales desde una perspectiva multidisciplinaria e interdisciplinaria. Al finalizar la carrera el profesional estará capacitado para brindar información específica en contacto con el turista, en senderos de interpretación, circuitos guiados y podrá coordinar excursiones programadas.");
        }
        if(materiaAdapter.isEmpty()){
            //Materias de gestión empresarial del 0 al 30
            materiaAdapter.insert(0,"Inglés I",1);
            materiaAdapter.insert(1,"Introducción a la Economía",1);
            materiaAdapter.insert(2,"Introducción al Cálculo",1);
            materiaAdapter.insert(3,"Laboratorio Taller:Sistemas de Información Gerencial y Contable I",1);
            materiaAdapter.insert(4,"Introducción a la Administración y a la Estructura Organizacional",1);
            materiaAdapter.insert(5,"Probabilidad y Estadística",1);
            materiaAdapter.insert(6,"Inglés II",1);
            materiaAdapter.insert(7,"Microeconomía",1);
            materiaAdapter.insert(8,"Derecho Administrativo y Comercial",1);
            materiaAdapter.insert(9,"Comportamiento Organizacional",1);
            materiaAdapter.insert(10,"Laboratorio Taller:Sistemas de Información Gerencial y Contable II",2);
            materiaAdapter.insert(11,"Matemática Financiera",2);
            materiaAdapter.insert(12,"Macroeconomía",2);
            materiaAdapter.insert(13,"Inglés III",2);
            materiaAdapter.insert(14,"Introducción a las Herramientas Tecnológicas Aplicadas a la Gestión Empresarial I",2);
            materiaAdapter.insert(15,"Asignatura Optativa I",2);
            materiaAdapter.insert(16,"Costos y Presupuestos",2);
            materiaAdapter.insert(17,"Legislación Laboral y Liquidación de Sueldos",2);
            materiaAdapter.insert(18,"Laboratorio Taller:Gestión Tributaria",2);
            materiaAdapter.insert(19,"Investigación de Mercado",2);
            materiaAdapter.insert(20,"Introducción a las Herramientas Tecnológicas Aplicadas a la Gestión Empresarial II",2);
            materiaAdapter.insert(21,"Análisis Financiero",3);
            materiaAdapter.insert(22,"Gestión de Recursos Humanos",3);
            materiaAdapter.insert(23,"Laboratorio Taller:Planificación Estratégica",3);
            materiaAdapter.insert(24,"Control de Gestión",3);
            materiaAdapter.insert(25,"Gestión de la Calidad",3);
            materiaAdapter.insert(26,"Asignatura Optativa II",3);
            materiaAdapter.insert(27,"Marketing",3);
            materiaAdapter.insert(28,"Laboratorio Taller:Emprendedorismo y Proyectos de Inversión",3);
            materiaAdapter.insert(29,"Administración de las Operaciones",3);
            materiaAdapter.insert(30,"Laboratorio Taller:Práctica Profesional",3);
            //Materias de software del 31 al 57
            materiaAdapter.insert(31,"Introducción a la Programación",1);
            materiaAdapter.insert(32,"Laboratorio de Programación I",1);
            materiaAdapter.insert(33,"Matemática Aplicada I",1);
            //Inglés  id=0
            materiaAdapter.insert(34,"Arquitectura del computador",1);
            materiaAdapter.insert(35,"Laboratorio de Programación II",1);
            materiaAdapter.insert(36,"Estructura de Datos y Algoritmos",1);
            materiaAdapter.insert(37,"Matemática Aplicada II",1);
            materiaAdapter.insert(38,"Programación Orientada a Objetos",1);
            //Inglés II id=6
            materiaAdapter.insert(39,"Programación Web 1",2);
            materiaAdapter.insert(40,"Probabilidad y Estadística",2);
            //Inglés III =13
            materiaAdapter.insert(41,"Base de Datos I",2);
            materiaAdapter.insert(42,"Ingeniería de Software",2);
            materiaAdapter.insert(43,"Laboratorio de Programación III",2);
            materiaAdapter.insert(44,"Optativa I",2);
            materiaAdapter.insert(45,"Programación Web II",2);
            materiaAdapter.insert(46,"Base de Datos II",2);
            materiaAdapter.insert(47,"Inglés IV",2);
            materiaAdapter.insert(48,"Redes y Seguridad Informática",3);
            materiaAdapter.insert(49,"Laboratorio de Programación IV",3);
            materiaAdapter.insert(50,"Paradigmas de Programación",3);
            materiaAdapter.insert(51,"Gestión de proyecto de software y calidad",3);
            materiaAdapter.insert(52,"Sistemas operativos",3);
            materiaAdapter.insert(53,"Optativa II",3);
            materiaAdapter.insert(54,"Ética y Deontología Profesional",3);
            materiaAdapter.insert(55,"Legislación",3);
            materiaAdapter.insert(56,"Optativa III",3);
            materiaAdapter.insert(57,"Práctica Profesional",3);
            //Materias de Turismo del 58 al 85
            materiaAdapter.insert(58,"Introducción al Turismo",1);
            materiaAdapter.insert(59,"Recursos Culturales I",1);
            //Inglés I =0
            materiaAdapter.insert(60,"Laboratorio Taller de Comunicación e Imagen Personal",1);
            materiaAdapter.insert(61,"Destinos Turísticos Internacionales",1);
            materiaAdapter.insert(62,"Circuitos Turísticos Nacionales I",1);
            materiaAdapter.insert(63,"Recursos Culturales II",1);
            materiaAdapter.insert(64,"Laboratorio Taller Gestión de Servicios de la Hopsitalidad",1);
            //Inglés II=6
            materiaAdapter.insert(65,"Laboratorio Taller Gestión de Agencias de Viajes y Turismo I",1);
            //Inglés III=13
            materiaAdapter.insert(66,"Circuitos Turísticos Nacionales II",2);
            materiaAdapter.insert(67,"Administración de las Empresas TurísticasI",2);
            materiaAdapter.insert(68,"Circuitos Turísticos Provinciales I",2);
            materiaAdapter.insert(69,"Técnicas de Investigación",2);
            materiaAdapter.insert(70,"Laboratorio Taller de Organización de Eventos",2);
            materiaAdapter.insert(71,"Laboratorio Taller Gestión de Servicios de la Hospitalidad II",2);
            materiaAdapter.insert(72,"Laboratorio Taller Gestión de Agencias de Viajes y Turismo II",2);
            materiaAdapter.insert(73,"Administración de las Empresas Turísticas II",2);
            materiaAdapter.insert(74,"Circuitos Turísticos Provinciales II",2);
            materiaAdapter.insert(75,"Comercialización I",2);
            materiaAdapter.insert(76,"Optativa I",2);
            materiaAdapter.insert(77,"Laboratorio Taller de Formulación de Proyectos Turísticos",3);
            materiaAdapter.insert(78,"Comercialización II",3);
            materiaAdapter.insert(79,"Gestión y Planificación de Municipios Turísticos",3);
            materiaAdapter.insert(80,"Legislación Turística Aplicada",3);
            materiaAdapter.insert(81,"Ética y Deontología Profesional",3);
            materiaAdapter.insert(82,"Evaluación de Proyectos Turísticos",3);
            materiaAdapter.insert(83,"Gestión de la Calidad en Turismo y Hotelería",3);
            materiaAdapter.insert(84,"Práctica Profesional Integrada",3);
            materiaAdapter.insert(85,"Optativa II",3);

            //Guía de turismo del 86 al 106
            //Indroducción al turismo=58
            //Recursos Culturales I=59
            //Inglés I=0
            materiaAdapter.insert(86,"Organicaciones Turísticas",1);
            //Laboratorio Taller de Comunicación e Imagen Personal I=60
            //Circuito Turístico Nacionales I=62
            //Recursos Culturales II=63
            materiaAdapter.insert(87,"Geografía Turística Argentina",1);
            materiaAdapter.insert(88,"Laboratorio Taller de Comunicación e Imagen Personal II",1);
            //inglés II=6
            //ingkés II=13
            //Circuitos Turisticos nacionales II=66
            materiaAdapter.insert(89,"Geografía de San Luis",2);
            materiaAdapter.insert(90,"Laboratorio Taller de Circuitos Turísticos ProvincialesI",2);
            materiaAdapter.insert(91,"Portugués I",2);
            materiaAdapter.insert(92,"Relaciones Publicas y Huamanas",2);
            materiaAdapter.insert(93,"Laboratorio Taller de Técnica y Dinámica de Grupos I",2);
            materiaAdapter.insert(94,"Laboratorio Taller de Circuitos Turísticos Provinciales II",2);
            materiaAdapter.insert(95,"Primeros Auxilios",2);
            materiaAdapter.insert(96,"Laboratorio Taller de Interpretación I",2);
            materiaAdapter.insert(97,"Optativa I",2);
            materiaAdapter.insert(98,"Laboratorio Taller de Interpretación II",3);
            materiaAdapter.insert(99,"Laboratorio Taller de Técnica y Dinámica de Grupos II",3);
            materiaAdapter.insert(100,"Portugués II",3);
            materiaAdapter.insert(101,"Laboratorio Taller de Recreación Aplicada a Dinámica de Grupos Turísticos",3);
            materiaAdapter.insert(102,"Ética y Deontología Profesional",3);
            materiaAdapter.insert(103,"Legislación Turística Aplicada",3);
            materiaAdapter.insert(104,"Gestión de Calidad para el Servicio de Guiadas",3);
            materiaAdapter.insert(105,"Práctica Profesional Integrada",3);
            materiaAdapter.insert(106,"Optativa II",3);
        }
        if(carreraxMateriaAdapter.isEmpty()){
            //cargar Gestión empresarial
            for(int g=0;g<31;g++)
                carreraxMateriaAdapter.insert(g,1);

            //Cargar Soft
            for(int s=31;s<58;s++)
                carreraxMateriaAdapter.insert(s,2);
            carreraxMateriaAdapter.insert(13,2);//Inglés 3
            carreraxMateriaAdapter.insert(6,2);//Inglés 2
            carreraxMateriaAdapter.insert(0,2);//Inglés 1

            //Cargar Turismo
            for(int t=58;t<86;t++)
                carreraxMateriaAdapter.insert(t,3);
            carreraxMateriaAdapter.insert(13,3);//Inglés 3
            carreraxMateriaAdapter.insert(6,3);//Inglés 2
            carreraxMateriaAdapter.insert(0,3);//Inglés 1

            //cargat Guía de Turismo
            for(int gt=86;gt<107;gt++)
                carreraxMateriaAdapter.insert(gt,4);
            carreraxMateriaAdapter.insert(58,4);
            carreraxMateriaAdapter.insert(59,4);
            carreraxMateriaAdapter.insert(0,4);
            carreraxMateriaAdapter.insert(60,4);
            carreraxMateriaAdapter.insert(62,4);
            carreraxMateriaAdapter.insert(63,4);
            carreraxMateriaAdapter.insert(6,4);
            carreraxMateriaAdapter.insert(13,4);
            carreraxMateriaAdapter.insert(66,4);
        }
        if(profesional_queAdapter.isEmpty()){
            //Gestión Página 35
            profesional_queAdapter.insert(0,"Gestiona tareas de consultoría administrativo-contables y económico-financieras o de recursos humanos.",1);
            profesional_queAdapter.insert(1,"Construye y ejecuta informes técnicos sobre cualquier área de pertenencia de su formación.",1);
            profesional_queAdapter.insert(2,"Colabora en los estudios e investigaciones para la formulación y evaluación de proyectos de inversión.",1);
            profesional_queAdapter.insert(3,"Coordina e integra equipos de trabajo interdisciplinario.",1);
            profesional_queAdapter.insert(4,"Elabora informes técnicos internos para promover la constitución, desarrollo y fortalecimiento de las or-ganizaciones.",1);
            //Software p 37
            profesional_queAdapter.insert(5,"Participa en equipos integrados por especialistas de distintos campos del conocimiento.",2);
            profesional_queAdapter.insert(6,"Diseña y administra todo el cilo de vida del software",2);
            profesional_queAdapter.insert(7,"Opera y mantiene sistemas informáticos y soluciones de software",2);
            //Técnico en turismo P 40
            profesional_queAdapter.insert(8,"Genera nuevas ofertas de servicios en función de los requerimientos del mercado y la existencia de recur-sos turísticos.",3);
            profesional_queAdapter.insert(9,"Vincula el respeto por el patrimonio cultural y natural a la gestión comercial.",3);
            profesional_queAdapter.insert(10,"Planifica, programa y promociona servicios turísticos a nivel local, nacional e internacional. Administrar las operaciones de una empresa turística.",3);
            profesional_queAdapter.insert(11,"Instrumenta la faz operativa de las distintas áreas de gestión, respetando las características de cada uno de los servicios turísticos.",3);
            profesional_queAdapter.insert(12,"Coordina acciones interdepartamentales en la búsqueda de sistemas eficientes para suministrar el servicio turístico.",3);
            profesional_queAdapter.insert(13,"Controla el cumplimiento de los estándares de calidad previstos en los servicios turísticos.",3);
            profesional_queAdapter.insert(14,"Asesora en la gestión pública y privada, a organismos oficiales y organizacionales no gubernamentales de Turismo, en todo lo referido a los aspectos técnicos que correspondan a la planificación del sector.",3);
            // Guía en turismo p41
            profesional_queAdapter.insert(15,"Maneja adecuadamente las herramientas para gestionar de forma sostenible los recursos que dan soporte a la actividad y al patrimonio turístico.",4);
            profesional_queAdapter.insert(16,"Adquiere los conocimientos pertinentes sobre el patrimonio natural y cultural para recibir, informar, y asesorar adecuadamente al turista.",4);
            profesional_queAdapter.insert(17,"Posee conocimientos relacionados con la calidad en la prestación de los servicios.",4);
            profesional_queAdapter.insert(18,"Respeta y preserva el patrimonio cultural y natural de la provincia",4);
            profesional_queAdapter.insert(19,"Valora la trascendencia de la actividad turística en el desarrollo socio-económico de las comunidades loca-les.",4);
        }
        if(competente_enAdapter.isEmpty()){
            //gestión pag=35
            competente_enAdapter.insert(0,"Asistencia a los profesionales de cada sector en las distintas áreas funcionales de una organización buscando la productividad",1);
            competente_enAdapter.insert(1,"Asistencia y diseño de estrategias para implementar los cambios dentro de las organizaciones.",1);
            competente_enAdapter.insert(2,"Colaboración en el diseño de la cultura organizacional.",1);
            competente_enAdapter.insert(3,"Transformación de los planes estratégicos en acciones concretas",1);
            competente_enAdapter.insert(4,"Relevamiento y sistematización de la información para la toma de decisiones.",1);
            competente_enAdapter.insert(5,"Realización de diagnósticos organizacionales",1);
            competente_enAdapter.insert(6,"Participación en el desarrollo de políticas organizacionales.",1);
            //Software
            competente_enAdapter.insert(7,"Administración de equipos que diseñen, construyan y operen soluciones de software.",2);
            competente_enAdapter.insert(8,"Análisis, diseño y programación de soluciones informáticas aplicando las mejores prácticas.",2);
            competente_enAdapter.insert(9,"Participación de equipos de investigación y desarrollo.",2);
            competente_enAdapter.insert(10,"Transmisión de conocimientos en tareas relativas a su especialidad.",2);
            competente_enAdapter.insert(11,"Evaluación del impacto de las soluciones implementadas en las organizaciones y la comunidad.",2);
            competente_enAdapter.insert(12,"Desempeño con sentido ético respecto de clientes, usuarios, colegas y la sociedad en su conjunto.",2);
            // Tect en turismo
            competente_enAdapter.insert(13,"Estudio, procesamiento y diseño de circuitos turísticos para formar parte de la oferta turística lo-cal.",3);
            competente_enAdapter.insert(14,"Administración empresas de servicios turísticos.",3);
            competente_enAdapter.insert(15,"Gestión de procesos en el ámbito público relacionados con el desarrollo de los destinos turísticos.",3);
            competente_enAdapter.insert(16,"Cotización y comercialización servicios turísticos.",3);
            competente_enAdapter.insert(17,"Intermediación en la prestación de servicios turísticos.",3);
            //Guía de turismo
            competente_enAdapter.insert(18,"Estudio, procesamiento y operación de circuitos turísticos que forman parte de la oferta turística local.",4);
            competente_enAdapter.insert(19,"Conducción y coordinación de grupos de individuos.",4);
            competente_enAdapter.insert(20,"Programación y coordinación de actividades recreativas para el buen uso del tiempo libre.",4);
            competente_enAdapter.insert(21,"Conformación de equipos de trabajo interdisciplinario para el desarrollo de políticas vinculadas al sector.",4);
            competente_enAdapter.insert(22,"Asesoramiento en la planificación de nuevos circuitos turísticos.",4);
        }
        if(residenciaAdapter.isEmpty()){
            residenciaAdapter.insert(1,"La Universidad de La Punta, reglamenta un Sistema de Residencias Estudiantiles, con la meta de promocionar y facilitar el estudio de las diferentes carreras y tecnicaturas dictadas por esta Universidad. \n" +
                    "NOTA: Para acceder al sistema de residencias Universitarias, las solicitudes formales deberán ser solicitadas a las direcciones de las respectivas unidades académicas. ","Disponibilidad sujeta a cupo","CONTACTO DE RESIDENCIAS \n" +
                    "0266 4452000 - int. 6106","","http://admin.ulp.edu.ar/ULPWeb/Contenido/PaginaULP35/File/Ficha%20ingreso.pdf","http://admin.ulp.edu.ar/ULPWeb/Contenido/PaginaULP35/File/Declaracin%20jurada.pdf");
        }
        if(documentacionAdapter.isEmpty()){
            documentacionAdapter.insert(0,"Documento nacional de identidad (fotocopia 1ra y 2da hoja).",1);
            documentacionAdapter.insert(1,"Fotocopía de Cipe (Cédula de Identidad Provincial Electrónica)",1);
            documentacionAdapter.insert(2,"Fotocopia del Certificado de buena Salud",1);
        }
        if(comodidadAdapter.isEmpty())
        {
            comodidadAdapter.insert(0,"Departamentos totalmente amoblados, con capacidad para 4 personas",1);
            comodidadAdapter.insert(1,"Vajilla indispensable",1);
            comodidadAdapter.insert(2,"Servicio de ropa blanca, limpieza y mantención",1);
        }
        if(objetivoAdapter.isEmpty()){
            objetivoAdapter.insert(0,"Crear las condiciones que permitan un desarrollo pleno del rendimiento académico de los residentes.",1);
            objetivoAdapter.insert(1,"Promover entre los residentes, aquellas actividades destinadas a completar sus estudios específicos buscando la apertura con espíritu interdisciplinario.",1);
            objetivoAdapter.insert(2,"Fomentar entre los residentes la realización efectiva de los ideales de la solidaridad, justicia, igualdad, libertad y tolerancia .",1);
        }
        if(requisitoAdapter.isEmpty())
        {
            requisitoAdapter.insert(1,"Haber concluido la preinscripción web a la carrera");
            requisitoAdapter.insert(2,"Fotocopia de DNI (1 y 2 hoja)");
            requisitoAdapter.insert(3,"Fotocopia CIPE");
            requisitoAdapter.insert(4,"Fotocopia legalizada del Certificado Analítico, en caso de no poseerla, Constancia de Certificado de estudios en trámite, detallando si adeuda materias (en caso de adeudar materias tendrán plazo de presentar el Certificado Analítico definitivo hasta el 30 de Junio)");
            requisitoAdapter.insert(5,"2 fotos carnet 4 x 4");
            requisitoAdapter.insert(6,"Certificado de Buena Salud");
            requisitoAdapter.insert(7,"Acta de Nacimiento");
            requisitoAdapter.insert(8,"Para mayores de 25 años sin título de nivel polimodal o su equivalente, para quien la aprobación estará sujeta a una evaluación de acuerdo a lo dispuesto en la legislación nacional vigente");
        }
        if(requisitoxCarreraAdapter.isEmpty())
        {
            for(int i=1;i<8;i++){
                requisitoxCarreraAdapter.insert(i,1);
                requisitoxCarreraAdapter.insert(i,2);
                requisitoxCarreraAdapter.insert(i,3);
                requisitoxCarreraAdapter.insert(i,4);
            }
        }
        if(porQueEstudiarAdapter.isEmpty()){
            porQueEstudiarAdapter.insert(1,"Carreras Cortas.");
            porQueEstudiarAdapter.insert(2,"Rápida salida laboral.");
            porQueEstudiarAdapter.insert(3,"Educación pública y gratuita.");
            porQueEstudiarAdapter.insert(4,"Prácticas profesionales.");
            porQueEstudiarAdapter.insert(5,"Salidas educativas.");
            porQueEstudiarAdapter.insert(6,"Pasantías o becas de trabajo.");
            porQueEstudiarAdapter.insert(7,"Residencia Universitaria.");
        }
        if(acercaULPAdapter.isEmpty()){
            acercaULPAdapter.insert(1,"En el año 2004 se crea por ley II-0034, la Universidad de La Punta (ULP) con el propósito de formar profesionales en áreas estratégicas asociadas al crecimiento y progreso de la provincia. \n" +
                    "El campus universitario se encuentra ubicado en la ciudad de La Punta, a 20 kilómetros de San Luis. Su estructura edilicia fue diseñada por el reconocido arquitecto argentino Clorindo Testa, en un territorio de 51 hectáreas, 4373,00 m2.");
            acercaULPAdapter.insert(2,"Clorindo Testa fué arquitecto y artista plástico, tomado como ejemplo a nivel mundial debido a su perfil plástico e innovador. Efectuó obras representativas de la arquitectura nacional, entre las que se destacan: la Biblioteca Nacional de la República Argentina en Buenos Aires, el Banco de Londres en Buenos Aires, el Hospital Naval y el Colegio de Escribanos de la ciudad de Buenos Aires. \n" +
                    "El proyecto arquitectónico del campus de la ULP estuvo a cargo del equipo integrado por el arquitecto Clorindo Testa (asociados arquitectos Bompadre, Fontana) y los estudios SEPRA (arquitectos Peralta Ramos) y BMA Asociados (Arquitectos Bodas, Miani y Anger).");
            acercaULPAdapter.insert(3,"\n" +
                    "Clorindo Testa fué arquitecto y artista plástico, tomado como ejemplo a nivel mundial debido a su perfil plástico e innovador. Efectuó obras representativas de la arquitectura nacional, entre las que se destacan: la Biblioteca Nacional de la República Argentina en Buenos Aires, el Banco de Londres en Buenos Aires, el Hospital Naval y el Colegio de Escribanos de la ciudad de Buenos Aires. \n" +
                    "El proyecto arquitectónico del campus de la ULP estuvo a cargo del equipo integrado por el arquitecto Clorindo Testa (asociados arquitectos Bompadre, Fontana) y los estudios SEPRA (arquitectos Peralta Ramos) y BMA Asociados (Arquitectos Bodas, Miani y Anger).\n" +
                    "\n" +
                    "“El campus de la Universidad de La Punta es por su propuesta general, único en el país. Es un campus universitario pensado como tal, en su totalidad, desde un principio. Esto lo destaca del resto de las universidades porque, generalmente, se van diseñando y desarrollando a medida que van creciendo las instituciones”, manifestó en una entrevista brindada en el año 2010 el reconocido arquitecto, Clorindo Testa. \n" +
                    "Además, dijo: “Viajé a San Luis en el 2002 y nos pareció que el lugar para el campus estaba muy bien elegido y con un buen paisaje con un entorno especial. Realizamos el plan maestro general, en el que se proyectaron todos los edificios del campus de la ULP, e hicimos una galería semicubierta que une, y comunica los diferentes sectores de la universidad”");
        }
        if(autoridadesULPAdapter.isEmpty()){
            autoridadesULPAdapter.insert(0,"Fernando Salino","Rector");
            autoridadesULPAdapter.insert(1,"Ignacio Piccolo","Vicerrector y Director Campus Abierto ULP");
            autoridadesULPAdapter.insert(2,"Gonzalo Ventura Fernandez","Secretario General");
            autoridadesULPAdapter.insert(3,"Sandra Solivellas","Secretaria Académica");
            autoridadesULPAdapter.insert(4,"Paulino Goméz Miranda","Secretario de Extensión");
            autoridadesULPAdapter.insert(5,"Jorge Pereira","Secretario de Legal y Técnica");
        }
        if(misionULPAdapter.isEmpty()){
            misionULPAdapter.insert(0,"Ser el instrumento provincial para darle a cada habitante de San Luis la oportunidad de formarse intelectual, social y culturalmente");
        }
        if(visionULPAdapter.isEmpty()){
            visionULPAdapter.insert(0,"Ser una universidad de vanguardia, reconocida nacional e internacionalmente, por su calidad en la gestión universitaria y sus servicios de excelencia.");
        }
        if(valoresULPAdapter.isEmpty()){
            valoresULPAdapter.insert(0,"Tenemos vocación de servicio, atender las necesidades de la sociedad sanluiseña es nuestra prioridad y lo hacemos con gusto y calidez.");
            valoresULPAdapter.insert(1,"Somos serios, cumplimos nuestras promesas y compromisos siempre.");
            valoresULPAdapter.insert(2,"Somos confiables, nos comprometemos con nuestras tareas y elegimos la excelencia como único camino para alcanzar nuestros objetivos.");
            valoresULPAdapter.insert(3,"Buscamos el mejoramiento continuo de nuestra universidad, trabajamos con humildad y estamos abiertos a seguir aprendiendo.");
            valoresULPAdapter.insert(4,"Fomentamos el trabajo en equipo, la participación, la innovación y la creatividad.");
            valoresULPAdapter.insert(5,"Somos íntegros, trabajamos con ética y transparencia, procurando la equidad en todos los ámbitos en los que nos desempeñamos.");
        }
    }
    public void close() {
        sqlDB.close();
    }
    public Cursor getDatosCarrera() {
        Cursor r = null ;
//JOIN
        return r;
    }
    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context){
            super(context,DB_NAME, null , DB_VERSION);
        }

        public void onCreate(SQLiteDatabase db){

            db.execSQL(CarreraAdapter.CR_TABLE);
            db.execSQL(CarreraxMateriaAdapter.CR_TABLE);
            db.execSQL(ComodidadAdapter.CR_TABLE);
            db.execSQL(Competente_enAdapter.CR_TABLE);
            db.execSQL(DocumentacionAdapter.CR_TABLE);
            db.execSQL(FotoAdapter.CR_TABLE);
            db.execSQL(RequisitoxCarreraAdapter.CR_TABLE);
            db.execSQL(LugarAdapter.CR_TABLE);
            db.execSQL(MateriaAdapter.CR_TABLE);
            db.execSQL(ObjetivoAdapter.CR_TABLE);
            db.execSQL(Profesional_queAdapter.CR_TABLE);
            db.execSQL(RequisitoAdapter.CR_TABLE);
            db.execSQL(ResidenciaAdapter.CR_TABLE);
            db.execSQL(PorQueEstudiarAdapter.CR_TABLE);
            db.execSQL(NoticiaAdapter.CR_TABLE);
            db.execSQL(AcercaULPAdapter.CR_TABLE);
            db.execSQL(MisionULPAdapter.CR_TABLE);
            db.execSQL(ValoresULPAdapter.CR_TABLE);
            db.execSQL(VisionULPAdapter.CR_TABLE);
            db.execSQL(AutoridadesULPAdapter.CR_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //no se van a actualizar las tablas de momento
            //sorry.
            //Nahuel Ovejero.
        }


    }

    //Metodos de consulta a la BD
    public ArrayList<String> getAcercaULP(){
        ArrayList<String> acerca=new ArrayList<>();
       Cursor c= acercaULPAdapter.getAcerca();
        if(c.moveToFirst())
        {
            do {
                acerca.add(c.getString(c.getColumnIndex("Descripcion")));
            }while(c.moveToNext());
        }
        return acerca;
    }
    public ArrayList<Autoridades> getAutoridades(){
        ArrayList<Autoridades> autoridades=new ArrayList<>();
        Cursor c= autoridadesULPAdapter.getAutoridades();
        if(c.moveToFirst())
        {
            do {
               autoridades.add(new Autoridades(c.getString(c.getColumnIndex("Nombre")),c.getString(c.getColumnIndex("Cargo"))));
            }while(c.moveToNext());
        }
        return autoridades;
    }
    public ArrayList<String> getComodidadesResi(){
        ArrayList<String> comodidades=new ArrayList<>();
        Cursor c= comodidadAdapter.getComodidades();
        if(c.moveToFirst())
        {
            do {
                comodidades.add(c.getString(c.getColumnIndex("Descripcion")));
            }while(c.moveToNext());
        }
        return comodidades;
    }
    public ArrayList<String> getCompetente(int IdCarrera){
        ArrayList<String> competente=new ArrayList<>();
        Cursor c= competente_enAdapter.getCompetente(IdCarrera);
        if(c.moveToFirst())
        {
            do {
                competente.add(c.getString(c.getColumnIndex("Descripcion")));
            }while(c.moveToNext());
        }
        return competente;
    }

    public ArrayList<String> getDocumentacionResi(){
        ArrayList<String> documentacion=new ArrayList<>();
        Cursor c= comodidadAdapter.getComodidades();
        if(c.moveToFirst())
        {
            do {
                documentacion.add(c.getString(c.getColumnIndex("Descripcion")));
            }while(c.moveToNext());
        }
        return documentacion;
    }
    public Lugar getLugar(int IdLugar){
        Cursor l=lugarAdapter.getLugar(IdLugar);
        if(l.moveToFirst()){
            Lugar nLugar=new Lugar(l.getString(l.getColumnIndex("Direccion")),l.getString(l.getColumnIndex("Telefono")),l.getDouble(l.getColumnIndex("Latitud")),l.getDouble(l.getColumnIndex("Longitud")));
            return nLugar;
        }
        return null;
    }
    public String getMisionUlp(){
        Cursor c=misionULPAdapter.getMision();
        c.moveToFirst();
        return c.getString(c.getColumnIndex("Descripcion"));
    }
    public ArrayList<String> getObjetivoResi(){
        ArrayList<String> objetivos=new ArrayList<>();
        Cursor c= objetivoAdapter.getObjetivos();
        if(c.moveToFirst())
        {
            do {
                objetivos.add(c.getString(c.getColumnIndex("Descripcion")));
            }while(c.moveToNext());
        }
        return objetivos;
    }
    public ArrayList<String> getPorQueEstudiar(){
        ArrayList<String> porque=new ArrayList<>();
        Cursor c= objetivoAdapter.getObjetivos();
        if(c.moveToFirst())
        {
            do {
                porque.add(c.getString(c.getColumnIndex("Descripcion")));
            }while(c.moveToNext());
        }
        return porque;
    }
    public ArrayList<String> getProfesionalQue(int Idcarrera){
        ArrayList<String> profesionalQue=new ArrayList<>();
        Cursor c= profesional_queAdapter.getProfesional(Idcarrera);
        if(c.moveToFirst())
        {
            do {
                profesionalQue.add(c.getString(c.getColumnIndex("Descripcion")));
            }while(c.moveToNext());
        }
        return profesionalQue;
    }
    public ArrayList<String> getRequisitosInscripcion(){
        ArrayList<String> requisitos=new ArrayList<>();
        Cursor c= requisitoAdapter.getRequisitos();
        if(c.moveToFirst())
        {
            do {
                requisitos.add(c.getString(c.getColumnIndex("Descripcion")));
            }while(c.moveToNext());
        }
        return requisitos;
    }
    public Residencia getResidencia(){
        Cursor c=residenciaAdapter.getResidencia();
        return new Residencia(c.getString(c.getColumnIndex("Descripcion")),c.getString(c.getColumnIndex("Cupo")),c.getString(c.getColumnIndex("Contacto")),c.getString(c.getColumnIndex("URL_ficha_ingreso")),c.getString(c.getColumnIndex("URL_declaracion_jurada")));
    }
    public ArrayList<String> getValores(){
        ArrayList<String> valores=new ArrayList<>();
        Cursor c= valoresULPAdapter.getValores();
        if(c.moveToFirst())
        {
            do {
                valores.add(c.getString(c.getColumnIndex("Descripcion")));
            }while(c.moveToNext());
        }
        return valores;
    }
    public String getVision(){
        Cursor c=visionULPAdapter.getVision();
        return c.getString(c.getColumnIndex("Descripcion"));
    }
}

