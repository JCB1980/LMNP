let amortissement = function () {
  let valeurDuBien = document.querySelector("#A1").value;
  let montantAnnuelLoyer = document.querySelector("#A2").value;
  let HonorairesAgence = document.querySelector("#A3").value;
  let FraisNotaire = document.querySelector("#A4").value;
  let FraisBancaire = document.querySelector("#A5").value;
  let ValeurMobilier = document.querySelector("#A6").value;
  let MontantEmprunt = document.querySelector("#A7").value;
  let FraisAministration = document.querySelector("#A8").value;
  let FraiLocal = document.querySelector("#A9").value;
  let IndemnitésEviction = document.querySelector("#A10").value;
  let DépensesTravaux = document.querySelector("#A11").value;
  let ChargesLocatives = document.querySelector("#A12").value;
  let Impôts = document.querySelector("#A13").value;
  let PrimesAssurances = document.querySelector("#A14").value;
  let ProvisionsChargesCopropriété = document.querySelector("#A15").value;
  let IntérêtsEtFraisEmprunt = document.querySelector("#A16").value;
  let DéductionsSpécifiques = document.querySelector("#A17").value;

  const txAmortMobilier = 0.1;
  const txamortFrais = 0.2;
  const txamortStructure = 0.02;
  const txamortMenuiseries = 0.04;
  const txamortChauffage = 0.04;
  const txamortEtancheite = 0.07;
  const txamortRavalement = 0.07;
  const txamortElectricite = 0.04;
  const txamortPlomberie = 0.04;
  const txamortAscenseur = 0.04;

  const dureeAmortMobilier = 11;
  const dureeAmortFrais = 6;
  const dureeAmortStructure = 51;
  const dureeAmortMenuiserie = 26;
  const dureeAmortChauffage = 26;
  const dureeAmortEtancheite = 16;
  const dureeAmortRavalement = 16;
  const dureeAmortElect = 26;
  const dureeAmortPlomberie = 26;
  const dureeAmortAscenseur = 15;

  const TxRepartitionStructOuvrage = 0.824;
  const TxRepartitionMenuiseries = 0.034;
  const TxRepartitionChauffage = 0.032;
  const TxRepartitionEtancheite = 0.01;
  const TxRepartitionRavalement = 0.021;
  const TxRepartitionElectricite = 0.042;
  const TxRepartitionPlomberie = 0.037;
  const TxRepartitionAscenseur = 0.028;

  let partA = valeurDuBien * TxRepartitionStructOuvrage;
  let partB = valeurDuBien * TxRepartitionMenuiseries;
  let partC = valeurDuBien * TxRepartitionChauffage;
  let partD = valeurDuBien * TxRepartitionEtancheite;
  let partE = valeurDuBien * TxRepartitionRavalement;
  let partF = valeurDuBien * TxRepartitionElectricite;
  let partG = valeurDuBien * TxRepartitionPlomberie;
  let partH = valeurDuBien * TxRepartitionAscenseur;

  var date = document.getElementById("start_date").value;
  var dateBegin = moment(date);
  console.log(dateBegin.format("DD/MM/YYYY"));

  var dateEnd = moment().endOf("year");
  console.log(dateEnd.format("DD/MM/YYYY"));

  var duration = moment.duration(dateEnd.diff(dateBegin));
  var days = duration.asDays();
  console.log(Math.round(days));
  var DaysYear = 365;
  /*amortissement du mobilier*/

  var annuiteMobilier = ValeurMobilier * txAmortMobilier;
  var AnnuiteMobProra = Math.round((annuiteMobilier * days) / DaysYear);
  const tableauAmorMobilier = [
    { annee: "1", AnnuiteMobProra },
    { annee: "2", annuiteMobilier },
    { annee: "3", annuiteMobilier },
    { annee: "4", annuiteMobilier },
    { annee: "5", annuiteMobilier },
    { annee: "6", annuiteMobilier },
    { annee: "7", annuiteMobilier },
    { annee: "8", annuiteMobilier },
    { annee: "9", annuiteMobilier },
    { annee: "10", annuiteMobilier },
  ];
  console.table(tableauAmorMobilier);
  /*console.log(`Lannuité mobilier au prorata est de :${AnnuiteMobProra} euros`);*/

  /*for (let annee = 1; annee < dureeAmortMobilier; annee++) {
    console.log(
      `l'annuité mobilière de l'année ${annee} est de ${annuiteMobilier}`
    );
    document.getElementById("annuiteMobilier").innerHTML = annuiteMobilier;
  }
  /*var tableau = [annuiteMobilier];
  console.log(tableau);*/

  /* amortissement des frais d'établissement*/

  var annuiteFrais =
    (Number(FraisNotaire) + Number(FraisBancaire) + Number(HonorairesAgence)) *
    txamortFrais;
  var AnnuiteFraisProra = Math.round((annuiteFrais * days) / DaysYear);
  const tableauAmorFrais = [
    { annee: "1", AnnuiteFraisProra },
    { annee: "2", annuiteFrais },
    { annee: "3", annuiteFrais },
    { annee: "4", annuiteFrais },
    { annee: "5", annuiteFrais },
  ];
  console.table(tableauAmorFrais);
  /*for (let annee = 1; annee < dureeAmortFrais; annee++) {
    console.log(
      `l'annuité des frais de l'année ${annee} est de ${annuiteFrais} euros`
    );
    document.getElementById("annuiteFrais").innerHTML = annuiteFrais;
  }*/

  var annuiteAscenseur = partH * txamortAscenseur;
  var yes = document.querySelector('input[value="oui"]');
  console.log(yes);
  yes.onchange = function () {
    if (yes.checked) {
      annuiteAscenseur;
    } else {
      annuiteAscenseur = 0;
    }
  };
  console.log(yes.onchange);
  let annuiteStructure = partA * txamortStructure;
  /*for (let annee = 1; annee < dureeAmortStructure; annee++) {
    console.log(
      `l'annuité Structure de l'année ${annee} est de ${annuiteStructure} euros`
    );
  }*/
  let annuiteMenuiserie = partB * txamortMenuiseries;
  /*for (let annee = 1; annee < dureeAmortMenuiserie; annee++) {
    console.log(
      `l'annuité Menuiserie de l'année ${annee} est de ${annuiteMenuiserie} euros`
    );
  }*/
  let annuiteChauffage = partC * txamortChauffage;
  /*for (let annee = 1; annee < dureeAmortChauffage; annee++) {
    console.log(
      `l'annuité Chauffage de l'année ${annee} est de ${annuiteChauffage} euros`
    );
  }*/
  let annuiteEtancheite = partD * txamortEtancheite;
  /*console.log(annuiteEtancheite);
  for (let annee = 1; annee < dureeAmortEtancheite; annee++) {
    console.log(
      `l'annuité Etanchéité de l'année ${annee} est de ${annuiteEtancheite} euros`
    );
  }*/
  let annuiteRavalement = partE * txamortRavalement;
  /*for (let annee = 1; annee < dureeAmortRavalement; annee++) {
    console.log(
      `l'annuité Ravalament de l'année ${annee} est de ${annuiteRavalement} euros`
    );
  }*/
  let annuiteElectricite = partF * txamortElectricite;
  /* for (let annee = 1; annee < dureeAmortElect; annee++) {
    console.log(
      `l'annuité Electricité de l'année ${annee} est de ${annuiteElectricite} euros`
    );
  }*/
  let annuitePlomberie = partG * txamortPlomberie;
  /*for (let annee = 1; annee < dureeAmortPlomberie; annee++) {
    console.log(
      `l'annuité Plomberie de l'année ${annee} est de ${annuitePlomberie} euros`
    );
  }*/

  var annuiteImmobilier =
    Number(annuiteStructure) +
    Number(annuiteChauffage) +
    Number(annuiteElectricite) +
    Number(annuiteEtancheite) +
    Number(annuitePlomberie) +
    Number(annuiteMenuiserie) +
    Number(annuiteRavalement) +
    Number(annuiteAscenseur);

  var annStrucProra = Math.round((annuiteStructure * days) / DaysYear);
  var annChaufProra = Math.round((annuiteChauffage * days) / DaysYear);
  var annElecProra = Math.round((annuiteElectricite * days) / DaysYear);
  var annEtanProra = Math.round((annuiteEtancheite * days) / DaysYear);
  var annPlomProra = Math.round((annuitePlomberie * days) / DaysYear);
  var annMenuiProra = Math.round((annuiteMenuiserie * days) / DaysYear);
  var annRavalPropra = Math.round((annuiteRavalement * days) / DaysYear);
  var annAscProra = Math.round((annuiteAscenseur * days) / DaysYear);
  var TotAn1 =
    annStrucProra +
    annChaufProra +
    annElecProra +
    annEtanProra +
    annPlomProra +
    annMenuiProra +
    annRavalPropra +
    annAscProra;
  var TotAn2 =
    Number(annuiteStructure) +
    Number(annuiteChauffage) +
    Number(annuiteElectricite) +
    Number(annuiteEtancheite) +
    Number(annuitePlomberie) +
    Number(annuiteMenuiserie) +
    Number(annuiteRavalement) +
    Number(annuiteAscenseur);

  var TotAn3 =
    Number(annuiteStructure) +
    Number(annuiteChauffage) +
    Number(annuiteElectricite) +
    Number(annuiteEtancheite) +
    Number(annuitePlomberie) +
    Number(annuiteMenuiserie) +
    Number(annuiteRavalement) +
    Number(annuiteAscenseur);

  var TotAn4 =
    Number(annuiteStructure) +
    Number(annuiteChauffage) +
    Number(annuiteElectricite) +
    Number(annuiteEtancheite) +
    Number(annuitePlomberie) +
    Number(annuiteMenuiserie) +
    Number(annuiteRavalement) +
    Number(annuiteAscenseur);

  var TotAn5 =
    Number(annuiteStructure) +
    Number(annuiteChauffage) +
    Number(annuiteElectricite) +
    Number(annuiteEtancheite) +
    Number(annuitePlomberie) +
    Number(annuiteMenuiserie) +
    Number(annuiteRavalement) +
    Number(annuiteAscenseur);

  var TotAn6 =
    Number(annuiteStructure) +
    Number(annuiteChauffage) +
    Number(annuiteElectricite) +
    Number(annuiteEtancheite) +
    Number(annuitePlomberie) +
    Number(annuiteMenuiserie) +
    Number(annuiteRavalement) +
    Number(annuiteAscenseur);

  var TotAn7 =
    Number(annuiteStructure) +
    Number(annuiteChauffage) +
    Number(annuiteElectricite) +
    Number(annuiteEtancheite) +
    Number(annuitePlomberie) +
    Number(annuiteMenuiserie) +
    Number(annuiteRavalement) +
    Number(annuiteAscenseur);

  var TotAn8 =
    Number(annuiteStructure) +
    Number(annuiteChauffage) +
    Number(annuiteElectricite) +
    Number(annuiteEtancheite) +
    Number(annuitePlomberie) +
    Number(annuiteMenuiserie) +
    Number(annuiteRavalement) +
    Number(annuiteAscenseur);

  var TotAn9 =
    Number(annuiteStructure) +
    Number(annuiteChauffage) +
    Number(annuiteElectricite) +
    Number(annuiteEtancheite) +
    Number(annuitePlomberie) +
    Number(annuiteMenuiserie) +
    Number(annuiteRavalement) +
    Number(annuiteAscenseur);

  var TotAn10 =
    Number(annuiteStructure) +
    Number(annuiteChauffage) +
    Number(annuiteElectricite) +
    Number(annuiteEtancheite) +
    Number(annuitePlomberie) +
    Number(annuiteMenuiserie) +
    Number(annuiteRavalement) +
    Number(annuiteAscenseur);

  var TotAn11 =
    Number(annuiteStructure) +
    Number(annuiteChauffage) +
    Number(annuiteElectricite) +
    Number(annuiteEtancheite) +
    Number(annuitePlomberie) +
    Number(annuiteMenuiserie) +
    Number(annuiteRavalement) +
    Number(annuiteAscenseur);

  var TotAn12 =
    Number(annuiteStructure) +
    Number(annuiteChauffage) +
    Number(annuiteElectricite) +
    Number(annuiteEtancheite) +
    Number(annuitePlomberie) +
    Number(annuiteMenuiserie) +
    Number(annuiteRavalement) +
    Number(annuiteAscenseur);
  var TotAn13 =
    Number(annuiteStructure) +
    Number(annuiteChauffage) +
    Number(annuiteElectricite) +
    Number(annuiteEtancheite) +
    Number(annuitePlomberie) +
    Number(annuiteMenuiserie) +
    Number(annuiteRavalement) +
    Number(annuiteAscenseur);
  var TotAn14 =
    Number(annuiteStructure) +
    Number(annuiteChauffage) +
    Number(annuiteElectricite) +
    Number(annuiteEtancheite) +
    Number(annuitePlomberie) +
    Number(annuiteMenuiserie) +
    Number(annuiteRavalement) +
    Number(annuiteAscenseur);
  var TotAn15 =
    Number(annuiteStructure) +
    Number(annuiteChauffage) +
    Number(annuiteElectricite) +
    Number(annuiteEtancheite) +
    Number(annuitePlomberie) +
    Number(annuiteMenuiserie) +
    Number(annuiteRavalement) +
    Number(annuiteAscenseur);
  var TotAn16 =
    Number(annuiteStructure) +
    Number(annuiteChauffage) +
    Number(annuiteElectricite) +
    Number(annuitePlomberie) +
    Number(annuiteMenuiserie) +
    Number(annuiteAscenseur);
  var TotAn17 =
    Number(annuiteStructure) +
    Number(annuiteChauffage) +
    Number(annuiteElectricite) +
    Number(annuitePlomberie) +
    Number(annuiteMenuiserie) +
    Number(annuiteAscenseur);
  var TotAn18 =
    Number(annuiteStructure) +
    Number(annuiteChauffage) +
    Number(annuiteElectricite) +
    Number(annuitePlomberie) +
    Number(annuiteMenuiserie) +
    Number(annuiteAscenseur);
  var TotAn19 =
    Number(annuiteStructure) +
    Number(annuiteChauffage) +
    Number(annuiteElectricite) +
    Number(annuitePlomberie) +
    Number(annuiteMenuiserie) +
    Number(annuiteAscenseur);
  var TotAn20 =
    Number(annuiteStructure) +
    Number(annuiteChauffage) +
    Number(annuiteElectricite) +
    Number(annuitePlomberie) +
    Number(annuiteMenuiserie) +
    Number(annuiteAscenseur);
  var TotAn21 =
    Number(annuiteStructure) +
    Number(annuiteChauffage) +
    Number(annuiteElectricite) +
    Number(annuitePlomberie) +
    Number(annuiteMenuiserie) +
    Number(annuiteAscenseur);
  var TotAn22 =
    Number(annuiteStructure) +
    Number(annuiteChauffage) +
    Number(annuiteElectricite) +
    Number(annuitePlomberie) +
    Number(annuiteMenuiserie) +
    Number(annuiteAscenseur);
  var TotAn23 =
    Number(annuiteStructure) +
    Number(annuiteChauffage) +
    Number(annuiteElectricite) +
    Number(annuitePlomberie) +
    Number(annuiteMenuiserie) +
    Number(annuiteAscenseur);
  var TotAn24 =
    Number(annuiteStructure) +
    Number(annuiteChauffage) +
    Number(annuiteElectricite) +
    Number(annuitePlomberie) +
    Number(annuiteMenuiserie) +
    Number(annuiteAscenseur);
  var TotAn25 =
    Number(annuiteStructure) +
    Number(annuiteChauffage) +
    Number(annuiteElectricite) +
    Number(annuitePlomberie) +
    Number(annuiteMenuiserie) +
    Number(annuiteAscenseur);

  var TotAn26 = annuiteStructure;
  var TotAn27 = annuiteStructure;
  var TotAn28 = annuiteStructure;
  var TotAn29 = annuiteStructure;
  var TotAn30 = annuiteStructure;
  var TotAn31 = annuiteStructure;
  var TotAn32 = annuiteStructure;
  var TotAn33 = annuiteStructure;
  var TotAn34 = annuiteStructure;
  var TotAn35 = annuiteStructure;
  var TotAn36 = annuiteStructure;
  var TotAn37 = annuiteStructure;
  var TotAn38 = annuiteStructure;
  var TotAn39 = annuiteStructure;
  var TotAn40 = annuiteStructure;
  var TotAn41 = annuiteStructure;
  var TotAn42 = annuiteStructure;
  var TotAn43 = annuiteStructure;
  var TotAn44 = annuiteStructure;
  var TotAn45 = annuiteStructure;
  var TotAn46 = annuiteStructure;
  var TotAn47 = annuiteStructure;
  var TotAn48 = annuiteStructure;
  var TotAn49 = annuiteStructure;
  var TotAn50 = annuiteStructure;
  const tabAmorImmo = [
    {
      annee: "1",
      annStrucProra,
      annChaufProra,
      annElecProra,
      annEtanProra,
      annPlomProra,
      annMenuiProra,
      annRavalPropra,
      annAscProra,
      TotAn1,
    },
    {
      annee: "2",
      annuiteStructure,
      annuiteChauffage,
      annuiteElectricite,
      annuiteEtancheite,
      annuitePlomberie,
      annuiteMenuiserie,
      annuiteRavalement,
      annuiteAscenseur,
      TotAn2,
    },
    {
      annee: "3",
      annuiteStructure,
      annuiteChauffage,
      annuiteElectricite,
      annuiteEtancheite,
      annuitePlomberie,
      annuiteMenuiserie,
      annuiteRavalement,
      annuiteAscenseur,
      TotAn3,
    },
    {
      annee: "4",
      annuiteStructure,
      annuiteChauffage,
      annuiteElectricite,
      annuiteEtancheite,
      annuitePlomberie,
      annuiteMenuiserie,
      annuiteRavalement,
      annuiteAscenseur,
      TotAn4,
    },
    {
      annee: "5",
      annuiteStructure,
      annuiteChauffage,
      annuiteElectricite,
      annuiteEtancheite,
      annuitePlomberie,
      annuiteMenuiserie,
      annuiteRavalement,
      annuiteAscenseur,
      TotAn5,
    },
    {
      annee: "6",
      annuiteStructure,
      annuiteChauffage,
      annuiteElectricite,
      annuiteEtancheite,
      annuitePlomberie,
      annuiteMenuiserie,
      annuiteRavalement,
      annuiteAscenseur,
      TotAn6,
    },
    {
      annee: "7",
      annuiteStructure,
      annuiteChauffage,
      annuiteElectricite,
      annuiteEtancheite,
      annuitePlomberie,
      annuiteMenuiserie,
      annuiteRavalement,
      annuiteAscenseur,
      TotAn7,
    },
    {
      annee: "8",
      annuiteStructure,
      annuiteChauffage,
      annuiteElectricite,
      annuiteEtancheite,
      annuitePlomberie,
      annuiteMenuiserie,
      annuiteRavalement,
      annuiteAscenseur,
      TotAn8,
    },
    {
      annee: "9",
      annuiteStructure,
      annuiteChauffage,
      annuiteElectricite,
      annuiteEtancheite,
      annuitePlomberie,
      annuiteMenuiserie,
      annuiteRavalement,
      annuiteAscenseur,
      TotAn9,
    },
    {
      annee: "10",
      annuiteStructure,
      annuiteChauffage,
      annuiteElectricite,
      annuiteEtancheite,
      annuitePlomberie,
      annuiteMenuiserie,
      annuiteRavalement,
      annuiteAscenseur,
      TotAn10,
    },
    {
      annee: "11",
      annuiteStructure,
      annuiteChauffage,
      annuiteElectricite,
      annuiteEtancheite,
      annuitePlomberie,
      annuiteMenuiserie,
      annuiteRavalement,
      annuiteAscenseur,
      TotAn11,
    },
    {
      annee: "12",
      annuiteStructure,
      annuiteChauffage,
      annuiteElectricite,
      annuiteEtancheite,
      annuitePlomberie,
      annuiteMenuiserie,
      annuiteRavalement,
      annuiteAscenseur,
      TotAn12,
    },
    {
      annee: "13",
      annuiteStructure,
      annuiteChauffage,
      annuiteElectricite,
      annuiteEtancheite,
      annuitePlomberie,
      annuiteMenuiserie,
      annuiteRavalement,
      annuiteAscenseur,
      TotAn13,
    },
    {
      annee: "14",
      annuiteStructure,
      annuiteChauffage,
      annuiteElectricite,
      annuiteEtancheite,
      annuitePlomberie,
      annuiteMenuiserie,
      annuiteRavalement,
      annuiteAscenseur,
      TotAn14,
    },
    {
      annee: "15",
      annuiteStructure,
      annuiteChauffage,
      annuiteElectricite,
      annuiteEtancheite,
      annuitePlomberie,
      annuiteMenuiserie,
      annuiteRavalement,
      annuiteAscenseur,
      TotAn15,
    },
    {
      annee: "16",
      annuiteStructure,
      annuiteChauffage,
      annuiteElectricite,
      annuitePlomberie,
      annuiteMenuiserie,
      TotAn16,
    },
    {
      annee: "17",
      annuiteStructure,
      annuiteChauffage,
      annuiteElectricite,
      annuitePlomberie,
      annuiteMenuiserie,
      TotAn17,
    },
    {
      annee: "18",
      annuiteStructure,
      annuiteChauffage,
      annuiteElectricite,
      annuitePlomberie,
      annuiteMenuiserie,
      TotAn18,
    },
    {
      annee: "19",
      annuiteStructure,
      annuiteChauffage,
      annuiteElectricite,
      annuitePlomberie,
      annuiteMenuiserie,
      TotAn19,
    },
    {
      annee: "20",
      annuiteStructure,
      annuiteChauffage,
      annuiteElectricite,
      annuitePlomberie,
      annuiteMenuiserie,
      TotAn20,
    },
    {
      annee: "21",
      annuiteStructure,
      annuiteChauffage,
      annuiteElectricite,
      annuitePlomberie,
      annuiteMenuiserie,
      TotAn21,
    },
    {
      annee: "22",
      annuiteStructure,
      annuiteChauffage,
      annuiteElectricite,
      annuitePlomberie,
      annuiteMenuiserie,
      TotAn22,
    },
    {
      annee: "23",
      annuiteStructure,
      annuiteChauffage,
      annuiteElectricite,
      annuitePlomberie,
      annuiteMenuiserie,
      TotAn23,
    },
    {
      annee: "24",
      annuiteStructure,
      annuiteChauffage,
      annuiteElectricite,
      annuitePlomberie,
      annuiteMenuiserie,
      TotAn24,
    },
    { annee: "25", annuiteStructure, TotAn25 },
    { annee: "26", annuiteStructure, TotAn26 },
    { annee: "27", annuiteStructure, TotAn27 },
    { annee: "28", annuiteStructure, TotAn28 },
    { annee: "29", annuiteStructure, TotAn29 },
    { annee: "30", annuiteStructure, TotAn30 },
    { annee: "31", annuiteStructure, TotAn31 },
    { annee: "32", annuiteStructure, TotAn32 },
    { annee: "33", annuiteStructure, TotAn33 },
    { annee: "34", annuiteStructure, TotAn34 },
    { annee: "35", annuiteStructure, TotAn35 },
    { annee: "36", annuiteStructure, TotAn36 },
    { annee: "37", annuiteStructure, TotAn37 },
    { annee: "38", annuiteStructure, TotAn38 },
    { annee: "39", annuiteStructure, TotAn39 },
    { annee: "40", annuiteStructure, TotAn40 },
    { annee: "41", annuiteStructure, TotAn41 },
    { annee: "42", annuiteStructure, TotAn42 },
    { annee: "43", annuiteStructure, TotAn43 },
    { annee: "44", annuiteStructure, TotAn44 },
    { annee: "45", annuiteStructure, TotAn45 },
    { annee: "46", annuiteStructure, TotAn46 },
    { annee: "47", annuiteStructure, TotAn47 },
    { annee: "48", annuiteStructure, TotAn48 },
    { annee: "49", annuiteStructure, TotAn49 },
    { annee: "50", annuiteStructure, TotAn50 },
  ];
  console.table(tabAmorImmo);
  /* annuité proratisé*/

  /*var AnnuiteImmoProra = Math.round((annuiteImmobilier * days) / DaysYear);
  console.log(
    `L'annuité immobilier au prorata est de : ${AnnuiteImmoProra} euros`
  );

  var AnnuiteFraisProra = Math.round((annuiteFrais * days) / DaysYear);
  console.log(
    `Lannuité mobilier au prorata est de : ${AnnuiteFraisProra} euros`
  );*/

  console.log("annuité mobilier:" + annuiteMobilier);
  console.log("annuite frais :" + annuiteFrais);
  console.log("Annuité immobilier:" + annuiteImmobilier);

  document.getElementById("annuiteImmobilier").innerHTML = annuiteImmobilier;
};
