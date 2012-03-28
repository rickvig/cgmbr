package com.membro



import org.junit.*
import grails.test.mixin.*

@TestFor(MembroController)
@Mock(Membro)
class MembroControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/membro/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.membroInstanceList.size() == 0
        assert model.membroInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.membroInstance != null
    }

    void testSave() {
        controller.save()

        assert model.membroInstance != null
        assert view == '/membro/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/membro/show/1'
        assert controller.flash.message != null
        assert Membro.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/membro/list'


        populateValidParams(params)
        def membro = new Membro(params)

        assert membro.save() != null

        params.id = membro.id

        def model = controller.show()

        assert model.membroInstance == membro
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/membro/list'


        populateValidParams(params)
        def membro = new Membro(params)

        assert membro.save() != null

        params.id = membro.id

        def model = controller.edit()

        assert model.membroInstance == membro
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/membro/list'

        response.reset()


        populateValidParams(params)
        def membro = new Membro(params)

        assert membro.save() != null

        // test invalid parameters in update
        params.id = membro.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/membro/edit"
        assert model.membroInstance != null

        membro.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/membro/show/$membro.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        membro.clearErrors()

        populateValidParams(params)
        params.id = membro.id
        params.version = -1
        controller.update()

        assert view == "/membro/edit"
        assert model.membroInstance != null
        assert model.membroInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/membro/list'

        response.reset()

        populateValidParams(params)
        def membro = new Membro(params)

        assert membro.save() != null
        assert Membro.count() == 1

        params.id = membro.id

        controller.delete()

        assert Membro.count() == 0
        assert Membro.get(membro.id) == null
        assert response.redirectedUrl == '/membro/list'
    }
}
