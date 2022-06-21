package Day_12
//Create a generic function for type BaseBuildingMaterial and call it isSmallBuilding,
//which takes a Building with a building material T as an argument. If the materials needed are less than 500,
//print "small building", otherwise, print "large building".
open class BaseBuildingMaterial() {
    open val numberNeeded = 1
}
class Wood : BaseBuildingMaterial() {
    override val numberNeeded = 4
}
class Brick : BaseBuildingMaterial() {
    override val numberNeeded = 8
}
class Building<out T: BaseBuildingMaterial>(val buildingMaterial: T) {
    val baseMaterialsNeeded = 600
    val actualMaterialsNeeded = buildingMaterial.numberNeeded * baseMaterialsNeeded

    fun build() {
        println(" $actualMaterialsNeeded ${buildingMaterial::class.simpleName} required")
    }
}
fun <T: BaseBuildingMaterial> isSmallBuilding(building: Building<T>){
    if (building.actualMaterialsNeeded < 500) println("Small Building")
    else println("large building")
}
fun main(args: Array<String>) {
    Building(Wood()).build()
    isSmallBuilding(Building(Brick()))
}