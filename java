let amortissement = function (valeurdebase) {
  let a = document.querySelector("#A1").value;
  let b = document.querySelector("#A2").value;
  let c = document.querySelector("#A3").value;
  let d = document.querySelector("#A4").value;
  let e = document.querySelector("#A5").value;
  let f = document.querySelector("#A6").value;
  let g = document.querySelector("#A7").value;
  let h = document.querySelector("#A8").value;
  let i = document.querySelector("#A9").value;
  let j = document.querySelector("#A10").value;
  let k = document.querySelector("#A11").value;
  let l = document.querySelector("#A12").value;
  let m = document.querySelector("#A13").value;
  let n = document.querySelector("#A14").value;
  let o = document.querySelector("#A15").value;
  let p = document.querySelector("#A16").value;
  let q = document.querySelector("#A17").value;

  const tauxamortmobilier = 0.1;
  const txamortfrais = 0.2;
  const txamortstructure = 0.02;
  const txmortmenuiseries = 0.04;
  const txamortchauffage = 0.04;
  const txamortetanchéité = 0.07;
  const txamorttavalement = 0.07;
  const txamortelectricite = 0.04;
  const txamortplomberie = 0.04;

  let annuite = valeurdebase * tauxamortmobilier;
  console.log("annuité:" + annuite);
  amortissement(a);
  return annuite;
};
