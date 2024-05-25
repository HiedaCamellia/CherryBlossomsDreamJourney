package org.hiedacamellia.cherry_blossoms_dream_journey.common.registry;

import com.google.common.collect.Maps;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.hiedacamellia.cherry_blossoms_dream_journey.CherryBlossomsDreamJourney;
import org.hiedacamellia.cherry_blossoms_dream_journey.common.item.FanItem;
import org.hiedacamellia.cherry_blossoms_dream_journey.common.item.FoodList;
import org.hiedacamellia.cherry_blossoms_dream_journey.common.item.SakuraHeaddressItem;

import java.util.LinkedHashMap;
import java.util.function.Supplier;


public enum ModItems {
    SakuraBranch("sakura_branch",
            ()->new Item(new Item.Properties())),
    Sakura("sakura",
            ()->new Item(new Item.Properties())),
    CandyApple("candy_apple",
            ()->new Item(new Item.Properties().food(FoodList.CandyApple).craftRemainder(Items.STICK))),
    ChoumeijiSakuramochi("choumeiji_sakuramochi",
            ()->new Item(new Item.Properties().food(FoodList.ChoumeijiSakuramochi))),
    Omamori("omamori",
            ()->new Item(new Item.Properties())),
    BottledRedSyrup("bottled_red_syrup",
            ()->new Item(new Item.Properties().food(FoodList.BottledRedSyrup))),
    UnfiredTeacup("unfired_teacup",
            ()->new Item(new Item.Properties())),
    Teacup("teacup",
            ()->new Item(new Item.Properties())),
    BottledRedSugar("bottled_red_sugar",
            ()->new Item(new Item.Properties())),
    SanshokuDango("sanshoku_dango",
            ()->new Item(new Item.Properties().food(FoodList.SanshokuDango))),
    SaltedSakura("salted_sakura",
            ()->new Item(new Item.Properties().food(FoodList.SaltedSakura))),
    AzukiBean("azuki_bean",
            ()->new ItemNameBlockItem(ModBlocks.REGISTRY_BLOCK.get("azuki_bean_crop_block").get(),new Item.Properties())),
    Fan("fan",
            ()->new FanItem(new Item.Properties())),
    SakuraHeaddress("sakura_headdress",
            ()->new SakuraHeaddressItem(new Item.Properties().setNoRepair().stacksTo(1))),
    ;
    public static final DeferredRegister<Item> ITEMS =DeferredRegister.create(ForgeRegistries.ITEMS,CherryBlossomsDreamJourney.MODID);

    private final String pathName;
    private final Supplier<Item> itemSupplier;
    private final boolean addTab;
    private Item item;
    public static final LinkedHashMap<String,RegistryObject<Item>> REGISTRY_ITEM = Maps.newLinkedHashMap();
    public static RegistryObject<Item> registerWithTab(final String name, final Supplier<Item> supplier,final boolean addTab) {
        RegistryObject<Item> block = ITEMS.register(name, supplier);
        if(addTab){
            REGISTRY_ITEM.put(name,block);
        }
        return block;
    }

    private ModItems(String pathName, Supplier itemSupplier) {
        this.pathName = pathName;
        this.itemSupplier = itemSupplier;
        this.addTab = true;
    }
    private ModItems(String pathName, Supplier itemSupplier,boolean addTab) {
        this.pathName = pathName;
        this.itemSupplier = itemSupplier;
        this.addTab = addTab;
    }
    static {
        for (ModItems value : values()) {
            registerWithTab(value.pathName, value.itemSupplier, value.addTab);
        }
    }
    public Item get() {
        if (this.item == null) {
            this.item = (Item)this.itemSupplier.get();
        }

        return this.item;
    }
    public RegistryObject<Item> getRegistryObject() {
        return REGISTRY_ITEM.get(this.pathName);
    }
    public Supplier<Item> getSupplier() {
        return this.itemSupplier;
    }
    public String getPath() {
        return this.pathName;
    }
}
