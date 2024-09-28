package nazario.researchfrontiers.research;

import net.minecraft.item.Items;

public class Elements {
    public static final Element HYDROGEN = new Element(1, "H", "Hydrogen", ElementCategory.REACTIVE_NONMETALS, ElementState.GAS).setPosition(0,0);
    public static final Element HELIUM = new Element(2, "He", "Helium", ElementCategory.NOBLE_GASES, ElementState.GAS).setPosition(272,0);
    public static final Element LITHIUM = new Element(3, "Li", "Lithium", ElementCategory.ALKALI_METALS, ElementState.SOLID).setPosition(0, 16);
    public static final Element BERYLLIUM = new Element(4, "Be", "Beryllium", ElementCategory.ALKALI_EARTH_METALS, ElementState.SOLID).setPosition(16, 16);
    public static final Element BORON = new Element(5, "B", "Boron", ElementCategory.METALLOIDS, ElementState.SOLID).setPosition(192, 16);
    public static final Element CARBON = new Element(6, "C", "Carbon", ElementCategory.REACTIVE_NONMETALS, ElementState.SOLID).setPosition(208, 16).setItem(Items.COAL);
    public static final Element NITROGEN = new Element(7, "N", "Nitrogen", ElementCategory.REACTIVE_NONMETALS, ElementState.GAS).setPosition(224, 16);
    public static final Element OXYGEN = new Element(8, "O", "Oxygen", ElementCategory.REACTIVE_NONMETALS, ElementState.GAS).setPosition(240, 16);
    public static final Element FLUORINE = new Element(9, "F", "Fluorine", ElementCategory.REACTIVE_NONMETALS, ElementState.GAS).setPosition(256, 16);
    public static final Element NEON = new Element(10, "Ne", "Neon", ElementCategory.NOBLE_GASES, ElementState.GAS).setPosition(272, 16);
    public static final Element SODIUM = new Element(11, "Na", "Sodium", ElementCategory.ALKALI_METALS, ElementState.SOLID).setPosition(0, 32);
    public static final Element MAGNESIUM = new Element(12, "Mg", "Magnesium", ElementCategory.ALKALI_EARTH_METALS, ElementState.SOLID).setPosition(16, 32);
    public static final Element ALUMINUM = new Element(13, "Al", "Aluminum", ElementCategory.POST_TRANSITION_METALS, ElementState.SOLID).setPosition(192, 32);
    public static final Element SILICON = new Element(14, "Si", "Silicon", ElementCategory.METALLOIDS, ElementState.SOLID).setPosition(208, 32);
    public static final Element PHOSPHORUS = new Element(15, "P", "Phosphorus", ElementCategory.REACTIVE_NONMETALS, ElementState.SOLID).setPosition(224, 32);
    public static final Element SULFUR = new Element(16, "S", "Sulfur", ElementCategory.REACTIVE_NONMETALS, ElementState.SOLID).setPosition(240, 32);
    public static final Element CHLORINE = new Element(17, "Cl", "Chlorine", ElementCategory.REACTIVE_NONMETALS, ElementState.GAS).setPosition(256, 32);
    public static final Element ARGON = new Element(18, "Ar", "Argon", ElementCategory.NOBLE_GASES, ElementState.GAS).setPosition(272, 32);
    public static final Element POTASSIUM = new Element(19, "K", "Potassium", ElementCategory.ALKALI_METALS, ElementState.SOLID).setPosition(  0, 48);
    public static final Element CALCIUM = new Element(20, "Ca", "Calcium", ElementCategory.ALKALI_EARTH_METALS, ElementState.SOLID).setPosition( 16, 48);
    public static final Element SCANDIUM = new Element(21, "Sc", "Scandium", ElementCategory.TRANSITION_METALS, ElementState.SOLID).setPosition( 32, 48);
    public static final Element TITANIUM = new Element(22, "Ti", "Titanium", ElementCategory.TRANSITION_METALS, ElementState.SOLID).setPosition( 48, 48);
    public static final Element VANADIUM = new Element(23, "V", "Vanadium", ElementCategory.TRANSITION_METALS, ElementState.SOLID).setPosition( 64, 48);
    public static final Element CHROMIUM = new Element(24, "Cr", "Chromium", ElementCategory.TRANSITION_METALS, ElementState.SOLID).setPosition( 80, 48);
    public static final Element MANGANESE = new Element(25, "Mn", "Manganese", ElementCategory.TRANSITION_METALS, ElementState.SOLID).setPosition( 96, 48);
    public static final Element IRON = new Element(26, "Fe", "Iron", ElementCategory.TRANSITION_METALS, ElementState.SOLID).setPosition(112, 48).setItem(Items.IRON_INGOT);
    public static final Element COBALT = new Element(27, "Co", "Cobalt", ElementCategory.TRANSITION_METALS, ElementState.SOLID).setPosition(128, 48);
    public static final Element NICKEL = new Element(28, "Ni", "Nickel", ElementCategory.TRANSITION_METALS, ElementState.SOLID).setPosition(144, 48);
    public static final Element COPPER = new Element(29, "Cu", "Copper", ElementCategory.TRANSITION_METALS, ElementState.SOLID).setPosition(160, 48);
    public static final Element ZINC = new Element(30, "Zn", "Zinc", ElementCategory.TRANSITION_METALS, ElementState.SOLID).setPosition(176, 48);
    public static final Element GALLIUM = new Element(31, "Ga", "Gallium", ElementCategory.POST_TRANSITION_METALS, ElementState.SOLID).setPosition(192, 48);
    public static final Element GERMANIUM = new Element(32, "Ge", "Germanium", ElementCategory.METALLOIDS, ElementState.SOLID).setPosition(208, 48);
    public static final Element ARSENIC = new Element(33, "As", "Arsenic", ElementCategory.METALLOIDS, ElementState.SOLID).setPosition(224, 48);
    public static final Element SELENIUM = new Element(34, "Se", "Selenium", ElementCategory.REACTIVE_NONMETALS, ElementState.SOLID).setPosition(240, 48);
    public static final Element BROMINE = new Element(35, "Br", "Bromine", ElementCategory.REACTIVE_NONMETALS, ElementState.LIQUID).setPosition(256, 48);
    public static final Element KRYPTON = new Element(36, "Kr", "Krypton", ElementCategory.NOBLE_GASES, ElementState.GAS).setPosition(272, 48);
    public static final Element RUBIDIUM = new Element(37, "Rb", "Rubidium", ElementCategory.ALKALI_METALS, ElementState.SOLID).setPosition(  0, 64);
    public static final Element STRONTIUM = new Element(38, "Sr", "Strontium", ElementCategory.ALKALI_EARTH_METALS, ElementState.SOLID).setPosition( 16, 64);
    public static final Element YTTRIUM = new Element(39, "Y", "Yttrium", ElementCategory.TRANSITION_METALS, ElementState.SOLID).setPosition( 32, 64);
    public static final Element ZIRCONIUM = new Element(40, "Zr", "Zirconium", ElementCategory.TRANSITION_METALS, ElementState.SOLID).setPosition( 48, 64);
    public static final Element NIOBIUM = new Element(41, "Nb", "Niobium", ElementCategory.TRANSITION_METALS, ElementState.SOLID).setPosition( 64, 64);
    public static final Element MOLYBDENUM = new Element(42, "Mo", "Molybdenum", ElementCategory.TRANSITION_METALS, ElementState.SOLID).setPosition( 80, 64);
    public static final Element TECHNETIUM = new Element(43, "Tc", "Technetium", ElementCategory.TRANSITION_METALS, ElementState.SOLID).setPosition( 96, 64);
    public static final Element RUTHENIUM = new Element(44, "Ru", "Ruthenium", ElementCategory.TRANSITION_METALS, ElementState.SOLID).setPosition(112, 64);
    public static final Element RHODIUM = new Element(45, "Rh", "Rhodium", ElementCategory.TRANSITION_METALS, ElementState.SOLID).setPosition(128, 64);
    public static final Element PALLADIUM = new Element(46, "Pd", "Palladium", ElementCategory.TRANSITION_METALS, ElementState.SOLID).setPosition(144, 64);
    public static final Element SILVER = new Element(47, "Ag", "Silver", ElementCategory.TRANSITION_METALS, ElementState.SOLID).setPosition(160, 64);
    public static final Element CADMIUM = new Element(48, "Cd", "Cadmium", ElementCategory.TRANSITION_METALS, ElementState.SOLID).setPosition(176, 64);
    public static final Element INDIUM = new Element(49, "In", "Indium", ElementCategory.POST_TRANSITION_METALS, ElementState.SOLID).setPosition(192, 64);
    public static final Element TIN = new Element(50, "Sn", "Tin", ElementCategory.POST_TRANSITION_METALS, ElementState.SOLID).setPosition(208, 64);
    public static final Element ANTIMONY = new Element(51, "Sb", "Antimony", ElementCategory.METALLOIDS, ElementState.SOLID).setPosition(224, 64);
    public static final Element TELLURIUM = new Element(52, "Te", "Tellurium", ElementCategory.METALLOIDS, ElementState.SOLID).setPosition(240, 64);
    public static final Element IODINE = new Element(53, "I", "Iodine", ElementCategory.REACTIVE_NONMETALS, ElementState.SOLID).setPosition(256, 64);
    public static final Element XENON = new Element(54, "Xe", "Xenon", ElementCategory.NOBLE_GASES, ElementState.GAS).setPosition(272, 64);
    public static final Element CESIUM = new Element(55, "Cs", "Cesium", ElementCategory.ALKALI_METALS, ElementState.SOLID);
    public static final Element BARIUM = new Element(56, "Ba", "Barium", ElementCategory.ALKALI_EARTH_METALS, ElementState.SOLID);
    public static final Element LANTHANUM = new Element(57, "La", "Lanthanum", ElementCategory.LANTHANOIDS, ElementState.SOLID);
    public static final Element CERIUM = new Element(58, "Ce", "Cerium", ElementCategory.LANTHANOIDS, ElementState.SOLID);
    public static final Element PRASEODYMIUM = new Element(59, "Pr", "Praseodymium", ElementCategory.LANTHANOIDS, ElementState.SOLID);
    public static final Element NEODYMIUM = new Element(60, "Nd", "Neodymium", ElementCategory.LANTHANOIDS, ElementState.SOLID);
    public static final Element PROMETHIUM = new Element(61, "Pm", "Promethium", ElementCategory.LANTHANOIDS, ElementState.SOLID);
    public static final Element SAMARIUM = new Element(62, "Sm", "Samarium", ElementCategory.LANTHANOIDS, ElementState.SOLID);
    public static final Element EUROPIUM = new Element(63, "Eu", "Europium", ElementCategory.LANTHANOIDS, ElementState.SOLID);
    public static final Element GADOLINIUM = new Element(64, "Gd", "Gadolinium", ElementCategory.LANTHANOIDS, ElementState.SOLID);
    public static final Element TERBIUM = new Element(65, "Tb", "Terbium", ElementCategory.LANTHANOIDS, ElementState.SOLID);
    public static final Element DYSPROSIUM = new Element(66, "Dy", "Dysprosium", ElementCategory.LANTHANOIDS, ElementState.SOLID);
    public static final Element HOLMIUM = new Element(67, "Ho", "Holmium", ElementCategory.LANTHANOIDS, ElementState.SOLID);
    public static final Element ERBIUM = new Element(68, "Er", "Erbium", ElementCategory.LANTHANOIDS, ElementState.SOLID);
    public static final Element THULIUM = new Element(69, "Tm", "Thulium", ElementCategory.LANTHANOIDS, ElementState.SOLID);
    public static final Element YTTERBIUM = new Element(70, "Yb", "Ytterbium", ElementCategory.LANTHANOIDS, ElementState.SOLID);
    public static final Element LUTETIUM = new Element(71, "Lu", "Lutetium", ElementCategory.LANTHANOIDS, ElementState.SOLID);
    public static final Element HAFNIUM = new Element(72, "Hf", "Hafnium", ElementCategory.TRANSITION_METALS, ElementState.SOLID);
    public static final Element TANTALUM = new Element(73, "Ta", "Tantalum", ElementCategory.TRANSITION_METALS, ElementState.SOLID);
    public static final Element TUNGSTEN = new Element(74, "W", "Tungsten", ElementCategory.TRANSITION_METALS, ElementState.SOLID);
    public static final Element RHENIUM = new Element(75, "Re", "Rhenium", ElementCategory.TRANSITION_METALS, ElementState.SOLID);
    public static final Element OSMIUM = new Element(76, "Os", "Osmium", ElementCategory.TRANSITION_METALS, ElementState.SOLID);
    public static final Element IRIDIUM = new Element(77, "Ir", "Iridium", ElementCategory.TRANSITION_METALS, ElementState.SOLID);
    public static final Element PLATINUM = new Element(78, "Pt", "Platinum", ElementCategory.TRANSITION_METALS, ElementState.SOLID);
    public static final Element GOLD = new Element(79, "Au", "Gold", ElementCategory.TRANSITION_METALS, ElementState.SOLID);
    public static final Element MERCURY = new Element(80, "Hg", "Mercury", ElementCategory.TRANSITION_METALS, ElementState.LIQUID);
    public static final Element THALLIUM = new Element(81, "Tl", "Thallium", ElementCategory.POST_TRANSITION_METALS, ElementState.SOLID);
    public static final Element LEAD = new Element(82, "Pb", "Lead", ElementCategory.POST_TRANSITION_METALS, ElementState.SOLID);
    public static final Element BISMUTH = new Element(83, "Bi", "Bismuth", ElementCategory.POST_TRANSITION_METALS, ElementState.SOLID);
    public static final Element POLONIUM = new Element(84, "Po", "Polonium", ElementCategory.POST_TRANSITION_METALS, ElementState.SOLID);
    public static final Element ASTATINE = new Element(85, "At", "Astatine", ElementCategory.METALLOIDS, ElementState.SOLID);
    public static final Element RADON = new Element(86, "Rn", "Radon", ElementCategory.NOBLE_GASES, ElementState.GAS);
    public static final Element FRANCIUM = new Element(87, "Fr", "Francium", ElementCategory.ALKALI_METALS, ElementState.SOLID);
    public static final Element RADIUM = new Element(88, "Ra", "Radium", ElementCategory.ALKALI_EARTH_METALS, ElementState.SOLID);
    public static final Element ACTINIUM = new Element(89, "Ac", "Actinium", ElementCategory.ACTINOIDS, ElementState.SOLID);
    public static final Element THORIUM = new Element(90, "Th", "Thorium", ElementCategory.ACTINOIDS, ElementState.SOLID);
    public static final Element PROTACTINIUM = new Element(91, "Pa", "Protactinium", ElementCategory.ACTINOIDS, ElementState.SOLID);
    public static final Element URANIUM = new Element(92, "U", "Uranium", ElementCategory.ACTINOIDS, ElementState.SOLID);
    public static final Element NEPTUNIUM = new Element(93, "Np", "Neptunium", ElementCategory.ACTINOIDS, ElementState.SOLID);
    public static final Element PLUTONIUM = new Element(94, "Pu", "Plutonium", ElementCategory.ACTINOIDS, ElementState.SOLID);
    public static final Element AMERICIUM = new Element(95, "Am", "Americium", ElementCategory.ACTINOIDS, ElementState.SOLID);
    public static final Element CURIUM = new Element(96, "Cm", "Curium", ElementCategory.ACTINOIDS, ElementState.SOLID);
    public static final Element BERKELIUM = new Element(97, "Bk", "Berkelium", ElementCategory.ACTINOIDS, ElementState.SOLID);
    public static final Element CALIFORNIUM = new Element(98, "Cf", "Californium", ElementCategory.ACTINOIDS, ElementState.SOLID);
    public static final Element EINSTEINIUM = new Element(99, "Es", "Einsteinium", ElementCategory.ACTINOIDS, ElementState.SOLID);
    public static final Element FERMIUM = new Element(100, "Fm", "Fermium", ElementCategory.ACTINOIDS, ElementState.SOLID);
    public static final Element MENDELEVIUM = new Element(101, "Md", "Mendelevium", ElementCategory.ACTINOIDS, ElementState.SOLID);
    public static final Element NOBELIUM = new Element(102, "No", "Nobelium", ElementCategory.ACTINOIDS, ElementState.SOLID);
    public static final Element LAWRENCIUM = new Element(103, "Lr", "Lawrencium", ElementCategory.ACTINOIDS, ElementState.SOLID);
    public static final Element RUTHERFORDIUM = new Element(104, "Rf", "Rutherfordium", ElementCategory.TRANSITION_METALS, ElementState.SOLID);
    public static final Element DUBNIUM = new Element(105, "Db", "Dubnium", ElementCategory.TRANSITION_METALS, ElementState.SOLID);
    public static final Element SEABORGIUM = new Element(106, "Sg", "Seaborgium", ElementCategory.TRANSITION_METALS, ElementState.SOLID);
    public static final Element BOHRIUM = new Element(107, "Bh", "Bohrium", ElementCategory.TRANSITION_METALS, ElementState.SOLID);
    public static final Element HASSIUM = new Element(108, "Hs", "Hassium", ElementCategory.TRANSITION_METALS, ElementState.SOLID);
    public static final Element MEITNERIUM = new Element(109, "Mt", "Meitnerium", ElementCategory.UNKNOWN, ElementState.UNKNOWN);
    public static final Element DARMSTADTIUM = new Element(110, "Ds", "Darmstadtium", ElementCategory.UNKNOWN, ElementState.UNKNOWN);
    public static final Element ROENTGENIUM = new Element(111, "Rg", "Roentgenium", ElementCategory.UNKNOWN, ElementState.UNKNOWN);
    public static final Element COPERNICIUM = new Element(112, "Cn", "Copernicium", ElementCategory.UNKNOWN, ElementState.UNKNOWN);
    public static final Element NIHONIUM = new Element(113, "Nh", "Nihonium", ElementCategory.UNKNOWN, ElementState.UNKNOWN);
    public static final Element FLEROVIUM = new Element(114, "Fl", "Flerovium", ElementCategory.UNKNOWN, ElementState.UNKNOWN);
    public static final Element MOSCOVIUM = new Element(115, "Mc", "Moscovium", ElementCategory.UNKNOWN, ElementState.UNKNOWN);
    public static final Element LIVERMORIUM = new Element(116, "Lv", "Livermorium", ElementCategory.UNKNOWN, ElementState.UNKNOWN);
    public static final Element TENNESSINE = new Element(117, "Ts", "Tennessine", ElementCategory.UNKNOWN, ElementState.UNKNOWN);
    public static final Element OGANESSON = new Element(118, "Og", "Oganesson", ElementCategory.UNKNOWN, ElementState.UNKNOWN);

    public static final Element[] ELEMENTS = {
            HYDROGEN, HELIUM, LITHIUM, BERYLLIUM, BORON, CARBON, NITROGEN, OXYGEN, FLUORINE, NEON,
            SODIUM, MAGNESIUM, ALUMINUM, SILICON, PHOSPHORUS, SULFUR, CHLORINE, ARGON, POTASSIUM, CALCIUM,
            SCANDIUM, TITANIUM, VANADIUM, CHROMIUM, MANGANESE, IRON, COBALT, NICKEL, COPPER, ZINC,
            GALLIUM, GERMANIUM, ARSENIC, SELENIUM, BROMINE, KRYPTON, RUBIDIUM, STRONTIUM, YTTRIUM, ZIRCONIUM,
            NIOBIUM, MOLYBDENUM, TECHNETIUM, RUTHENIUM, RHODIUM, PALLADIUM, SILVER, CADMIUM, INDIUM, TIN,
            ANTIMONY, TELLURIUM, IODINE, XENON, CESIUM, BARIUM, LANTHANUM, CERIUM, PRASEODYMIUM, NEODYMIUM,
            PROMETHIUM, SAMARIUM, EUROPIUM, GADOLINIUM, TERBIUM, DYSPROSIUM, HOLMIUM, ERBIUM, THULIUM, YTTERBIUM,
            LUTETIUM, HAFNIUM, TANTALUM, TUNGSTEN, RHENIUM, OSMIUM, IRIDIUM, PLATINUM, GOLD, MERCURY,
            THALLIUM, LEAD, BISMUTH, POLONIUM, ASTATINE, RADON, FRANCIUM, RADIUM, ACTINIUM, THORIUM,
            PROTACTINIUM, URANIUM, NEPTUNIUM, PLUTONIUM, AMERICIUM, CURIUM, BERKELIUM, CALIFORNIUM, EINSTEINIUM, FERMIUM,
            MENDELEVIUM, NOBELIUM, LAWRENCIUM, RUTHERFORDIUM, DUBNIUM, SEABORGIUM, BOHRIUM, HASSIUM, MEITNERIUM, DARMSTADTIUM,
            ROENTGENIUM, COPERNICIUM, NIHONIUM, FLEROVIUM, MOSCOVIUM, LIVERMORIUM, TENNESSINE, OGANESSON
    };

}
