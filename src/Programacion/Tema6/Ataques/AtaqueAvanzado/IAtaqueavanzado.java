package Programacion.Tema6.Ataques.AtaqueAvanzado;

import Programacion.Tema6.Ataques.AtaqueBase.IAtaque;

public interface IAtaqueavanzado extends IAtaque {

    int physicalDamage();
    int magicalDamage();
    int stamina();
    int mana();
}
